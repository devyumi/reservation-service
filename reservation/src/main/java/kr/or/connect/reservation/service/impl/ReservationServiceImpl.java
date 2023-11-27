package kr.or.connect.reservation.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.DisplayDao;
import kr.or.connect.reservation.dao.FileDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.Comment;
import kr.or.connect.reservation.domain.CommentDB;
import kr.or.connect.reservation.domain.CommentImageDB;
import kr.or.connect.reservation.domain.DisplayInfos;
import kr.or.connect.reservation.domain.FileInfoDB;
import kr.or.connect.reservation.domain.OrderInfos;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;
import kr.or.connect.reservation.domain.Promotion;
import kr.or.connect.reservation.domain.ReservationInfoDB;
import kr.or.connect.reservation.domain.ReservationInfoPriceDB;
import kr.or.connect.reservation.domain.ReservationPriceRequest;
import kr.or.connect.reservation.domain.ReservationPriceResponse;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.CommentResponseDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.OrderInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.ReservationRequestDto;
import kr.or.connect.reservation.dto.ReservationResponseDto;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	DisplayDao displayDao;
	@Autowired
	PromotionDao promotionDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	ReservationDao reservationDao;
	@Autowired
	FileDao fileDao;
	
	@Override
	public CategoryDto findCategories() {
		List<Category> categories = categoryDao.selectCategories();
		return new CategoryDto(categories.size(), categories);
	}

	@Override
	public DisplayInfosDto findDisplayInfos(int categoryId, int start) {
		List<DisplayInfos> displayInfos = displayDao.selectDisplayInfos(categoryId, start, ReservationService.DISPLAY_INFO_LIMIT);
		int displayInfoCount = displayDao.selectDisplayInfoCount(categoryId);
		return new DisplayInfosDto(displayInfoCount, displayInfos.size(), displayInfos);
	}

	@Override
	public PromotionDto findPromotions() {
		List<Promotion> promotions = promotionDao.selectPromotions();
		return new PromotionDto(promotions.size(), promotions);
	}
	
	@Override
	public DisplayInfoDto findDisplayInfo(int displayInfoId) {
		List<DisplayInfos> displayInfos = productDao.selectDisplayInfo(displayInfoId);
		List<ProductImage> productimages = productDao.selectProductImages(displayInfoId);
		List<DisplayInfoImage> displayInfoImages = productDao.selectDisplayInfoImages(displayInfoId);
		List<ProductPrice> productPrices = productDao.selectProductPrices(displayInfoId);
		int scoreAvg = commentDao.selectScoreAvg(displayInfoId);
		return new DisplayInfoDto(displayInfos, productimages, displayInfoImages, scoreAvg, productPrices);
	}
	
	@Override
	public CommentDto findComments(int productId, int start) {
		List<Comment> comments = commentDao.selectComments(productId, start, ReservationService.COMMENT_LIMIT);
		int commentCount = commentDao.selectCommentCount(productId);
		return new CommentDto(commentCount, comments.size(), comments);
	}
	
	@Override
	@Transactional(readOnly = false)
	public ReservationResponseDto RegisterReservation(ReservationRequestDto reservationRequest) {
		ReservationInfoDB reservationInfoDb = addReservationInfoDB(reservationRequest);
		int reservationInfoId = reservationDao.insertReservationInfo(reservationInfoDb);
		
		List<ReservationPriceResponse> prices = new ArrayList<ReservationPriceResponse>();
		for(ReservationPriceRequest r : reservationRequest.getPrices()) {
			ReservationInfoPriceDB reservationInfoPriceDB = addReservationInfoPriceDB(reservationInfoId, r);
			int reservationInfoPriceId = reservationDao.insertReservationInfoPrice(reservationInfoPriceDB);
			
			prices.add(new ReservationPriceResponse(
					reservationInfoPriceId,
					reservationInfoId,
					reservationInfoPriceDB.getProductPriceId(),
					reservationInfoPriceDB.getCount()));
		}

		return new ReservationResponseDto(reservationInfoId,
				reservationInfoDb.getProductId(),
				reservationInfoDb.getCancelFlag(),
				reservationInfoDb.getDisplayInfoId(),
				reservationInfoDb.getUserId(),
				reservationInfoDb.getReservationDate(),
				reservationInfoDb.getCreateDate(),
				reservationInfoDb.getModifyDate(),
				prices);
	}
	
	@Override
	@Transactional(readOnly = false)
	public ReservationInfoDB addReservationInfoDB(ReservationRequestDto reservationRequest) {
		return new ReservationInfoDB(
				reservationRequest.getProductId(),
				reservationRequest.getDisplayInfoId(),
				reservationRequest.getUserId(),
				reservationRequest.getReservationYearMonthDay().atStartOfDay(),
				0,
				LocalDateTime.now(),
				LocalDateTime.now());
	}
	
	@Override
	@Transactional(readOnly = false)
	public ReservationInfoPriceDB addReservationInfoPriceDB(int reservationInfoId, ReservationPriceRequest reservationPriceRequest) {
		return new ReservationInfoPriceDB(
				reservationInfoId,
				reservationPriceRequest.getProductPriceId(),
				reservationPriceRequest.getCount());
	}

	@Override
	public OrderInfosDto findOrderInfos(int userId) {
		List<OrderInfos> orderInfos = reservationDao.selectOrderInfos(userId);
		return new OrderInfosDto(orderInfos.size(), orderInfos);
	}

	@Override
	public int updateReservation(int reservationId, int userId) {
		return reservationDao.updateCancelFlag(reservationId, userId);
	}
	
	@Override
	public int findProductId(int reservationInfoId) {
		return productDao.selectProductId(reservationInfoId);
	}

	@Override
	@Transactional(readOnly = false)
	public CommentResponseDto RegisterComment(int productId, int reservationInfoId, int userId, int score,
			String comment, MultipartFile multipartFile) {
		
		CommentDB commentDb = addCommentDB(productId, reservationInfoId, userId, score, comment);
		int reservationUserCommentId = commentDao.insertComment(commentDb);
		
		FileInfoDB fileInfoDb = addFileInfoDB(multipartFile);
		int fileId = fileDao.insertFile(fileInfoDb);
		upload(multipartFile);
		
		CommentImageDB commentImageDb = addCommentImageDB(reservationInfoId, reservationUserCommentId, fileId);
		commentDao.insertCommentImage(commentImageDb);
		
		return new CommentResponseDto("success", productId);
	}
	
	@Override
	@Transactional(readOnly = false)
	public CommentDB addCommentDB(int productId, int reservationInfoId, int userId, int score,
			String comment) {
		return new CommentDB(productId, reservationInfoId, userId, score, comment,
							LocalDateTime.now(), LocalDateTime.now());
	}
	
	@Override
	@Transactional(readOnly = false)
	public FileInfoDB addFileInfoDB(MultipartFile multipartFile) {
		String saveFileName = "img/" + multipartFile.getOriginalFilename();
		return new FileInfoDB(multipartFile.getOriginalFilename(), saveFileName, multipartFile.getContentType(),
				0, LocalDateTime.now(), LocalDateTime.now());	
	}
	
	@Override
	@Transactional(readOnly = false)
	public CommentImageDB addCommentImageDB(int reservationInfoId, int reservationUserCommentId, int fileId) {
		return new CommentImageDB(reservationInfoId, reservationUserCommentId, fileId);
	}
	
	@Override
	public void upload(MultipartFile file) {
		try (
			FileOutputStream fos = new FileOutputStream("c:/tmp/" + file.getOriginalFilename());
			InputStream is = file.getInputStream();
			
		){
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while((readCount = is.read(buffer)) != -1){
				fos.write(buffer, 0, readCount);
		}
		}catch(Exception e) {
			throw new RuntimeException("file save Error");
		}
	}
}
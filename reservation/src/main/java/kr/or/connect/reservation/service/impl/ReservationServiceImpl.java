package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.Comment;
import kr.or.connect.reservation.domain.DisplayInfo;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;
import kr.or.connect.reservation.domain.Promotion;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.DisplayInfoIdDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationDao reservationDao;

	@Override
	public CategoryDto findCategory() {
		List<Category> categories = reservationDao.selectCategories();
		return new CategoryDto(categories.size(), categories);
	}

	@Override
	public DisplayInfoDto findDisplayInfo(int categoryId, int start) {
		List<DisplayInfo> displayInfos = reservationDao.selectDisplayInfos(categoryId, start, ReservationService.DISPLAY_INFO_LIMIT);
		int displayInfoCount = reservationDao.selectDisplayInfoCount(categoryId);
		return new DisplayInfoDto(displayInfoCount, displayInfos.size(), displayInfos);
	}

	@Override
	public PromotionDto findPromotion() {
		List<Promotion> promotions = reservationDao.selectPromotions();
		return new PromotionDto(promotions.size(), promotions);
	}
	
	@Override
	public DisplayInfoIdDto findDisplayInfoId(int displayInfoId) {
		List<DisplayInfo> displayInfos = reservationDao.selectDisplayInfoIds(displayInfoId);
		List<ProductImage> productimages = reservationDao.selectProductImages(displayInfoId);
		List<DisplayInfoImage> displayInfoImages = reservationDao.selectDisplayInfoImages(displayInfoId);
		List<ProductPrice> productPrices = reservationDao.selectProductPrices(displayInfoId);
		int scoreAvg = reservationDao.selectScoreAvg(displayInfoId);
		return new DisplayInfoIdDto(displayInfos, productimages, displayInfoImages, scoreAvg, productPrices);
	}
	
	@Override
	public CommentDto findComment(int productId, int start) {
		List<Comment> comments = reservationDao.selectComments(productId, start, ReservationService.COMMENT_LIMIT);
		int commentCount = reservationDao.selectCommentCount(productId);
		return new CommentDto(commentCount, comments.size(), comments);
	}
}
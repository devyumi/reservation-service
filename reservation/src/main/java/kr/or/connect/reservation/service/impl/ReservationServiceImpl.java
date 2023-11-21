package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.DisplayDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.Comment;
import kr.or.connect.reservation.domain.DisplayInfos;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;
import kr.or.connect.reservation.domain.Promotion;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
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
}
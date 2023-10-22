package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;

public interface ReservationService {
	static final Integer DISPLAY_INFO_LIMIT = 4;
	static final Integer COMMENT_LIMIT = 5;
	CategoryDto findCategories();
	DisplayInfosDto findDisplayInfos(int categoryId, int start);
	PromotionDto findPromotions();
	DisplayInfoDto findDisplayInfo(int displayInfoId);
	CommentDto findComments(int productId, int start);
}

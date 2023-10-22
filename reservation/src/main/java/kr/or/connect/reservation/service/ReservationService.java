package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.DisplayInfoIdDto;
import kr.or.connect.reservation.dto.PromotionDto;

public interface ReservationService {
	static final Integer DISPLAY_INFO_LIMIT = 4;
	static final Integer COMMENT_LIMIT = 5;
	CategoryDto findCategory();
	DisplayInfoDto findDisplayInfo(int categoryId, int start);
	PromotionDto findPromotion();
	DisplayInfoIdDto findDisplayInfoId(int displayInfoId);
	CommentDto findComment(int productId, int start);
}

package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;

public interface ReservationService {
	static final Integer DISPLAY_INFO_LIMIT = 4;
	CategoryDto findCategory();
	DisplayInfoDto findDisplayInfo(int categoryId, int start);
	PromotionDto findPromotion();
}

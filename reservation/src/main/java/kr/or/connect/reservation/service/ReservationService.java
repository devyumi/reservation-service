package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;

public interface ReservationService {
	static final Integer LIMIT = 4;
	CategoryDto findCategory();
	DisplayInfoDto findDisplayInfo(int categoryId, int start);
}

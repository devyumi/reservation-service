package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.domain.DisplayInfo;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
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
		List<DisplayInfo> displayInfos = reservationDao.selectDisplayInfos(categoryId, start, ReservationService.LIMIT);
		int displayInfoCount = reservationDao.selectDisplayInfoCount(categoryId);
		return new DisplayInfoDto(displayInfoCount, displayInfos.size(), displayInfos);
	}
}

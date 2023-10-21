package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationDao reservationDao;

	@Override
	public CategoryDto findCategoryDto() {
		List<Category> categories = reservationDao.selectCategories();
		return new CategoryDto(categories.size(), categories);
		
//		categoryDto.setItems(reservationDao.selectCategories()); 변경 전
//		categoryDto.setSize(categoryDto.getItems().size());
		
//		categoryDto.setSize(7);
//		categoryDto.setItems(Arrays.asList(new Category(1, "전시", 10), new Category(2, "뮤지컬", 12)));
	}
}

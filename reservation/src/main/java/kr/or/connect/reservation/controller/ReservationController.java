package kr.or.connect.reservation.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.DisplayInfoIdDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@GetMapping("api/categories")
	public CategoryDto findCategories() {
		return reservationService.findCategory();
	}
	
	@GetMapping("api/displayinfos")
	public DisplayInfoDto findDisplayInfos(@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
											@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findDisplayInfo(categoryId, start);
	}
	
	@GetMapping("api/promotions")
	public PromotionDto findPromotions() {
		return reservationService.findPromotion();
	}
	
	@GetMapping("api/displayinfos/{displayId}")
	public DisplayInfoIdDto findDisplayInfoIds(@PathVariable(name = "displayId") int displayInfoId) {
		return reservationService.findDisplayInfoId(displayInfoId);
	}
	
	@GetMapping("api/comments")
	public CommentDto findComments(@RequestParam(name = "productId", required = false, defaultValue = "0") int productId,
									@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findComment(productId, start);
	}
}

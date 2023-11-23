package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.ReservationRequestDto;
import kr.or.connect.reservation.dto.ReservationResponseDto;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping("api/v1")
public class ApiController {

	@Autowired
	ReservationService reservationService;
	
	@GetMapping("categories")
	public CategoryDto findCategories() {
		return reservationService.findCategories();
	}
	
	@GetMapping("displayinfos")
	public DisplayInfosDto findDisplayInfos(@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
											@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findDisplayInfos(categoryId, start);
	}
	
	@GetMapping("promotions")
	public PromotionDto findPromotions() {
		return reservationService.findPromotions();
	}
	
	@GetMapping("displayinfos/{displayId}")
	public DisplayInfoDto findDisplayInfo(@PathVariable(name = "displayId") int displayInfoId) {
		return reservationService.findDisplayInfo(displayInfoId);
	}
	
	@GetMapping("comments")
	public CommentDto findComments(@RequestParam(name = "productId", required = false, defaultValue = "0") int productId,
									@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findComments(productId, start);
	}
	
	@PostMapping("reservationinfos")
	public ReservationResponseDto RegisterReservations(@RequestBody ReservationRequestDto reservationRequest) {
		return reservationService.RegisterReservation(reservationRequest);
	}
}
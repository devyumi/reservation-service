package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.OrderInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.ReservationRequestDto;
import kr.or.connect.reservation.dto.ReservationResponseDto;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.UserService;
import kr.or.connect.reservation.service.security.CustomUserDetails;

@RestController
@RequestMapping("api/v1")
public class ApiController {

	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;
	
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
	
	@GetMapping("reservationinfos")
	public OrderInfosDto findOrderInfos(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		int userId = userService.getUserId(customUserDetails.getUsername());
		return reservationService.findOrderInfos(userId);
	}
	
	@PutMapping("reservationinfos")
	public Map<String, String> cancelReservation(@RequestBody Map<String, Integer> params,
			@AuthenticationPrincipal CustomUserDetails customUserDetails){
		int reservationId = params.get("id");
		int userId = userService.getUserId(customUserDetails.getUsername());
		int cancelFlag = reservationService.updateReservation(reservationId, userId);
		Map<String, String> result = new HashMap<String, String>();
		
		if(cancelFlag == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		return result;
	}
}
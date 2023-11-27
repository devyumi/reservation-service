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
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.CommentResponseDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.OrderInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.ReservationRequestDto;
import kr.or.connect.reservation.dto.ReservationResponseDto;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.UserService;
import kr.or.connect.reservation.service.security.CustomUserDetails;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("api/v1")
public class ApiController {

	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;
	
	@ApiOperation(value = "카테고리 목록 구하기")
	@GetMapping("categories")
	public CategoryDto findCategories() {
		return reservationService.findCategories();
	}
	
	@ApiOperation(value = "상품 목록 구하기")
	@GetMapping("displayinfos")
	public DisplayInfosDto findDisplayInfos(@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
											@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findDisplayInfos(categoryId, start);
	}
	
	@ApiOperation(value = "프로모션 정보 구하기")
	@GetMapping("promotions")
	public PromotionDto findPromotions() {
		return reservationService.findPromotions();
	}
	
	@ApiOperation(value = "전시 정보 구하기")
	@GetMapping("displayinfos/{displayId}")
	public DisplayInfoDto findDisplayInfo(@PathVariable(name = "displayId") int displayInfoId) {
		return reservationService.findDisplayInfo(displayInfoId);
	}
	
	@ApiOperation(value = "댓글 목록 구하기")
	@GetMapping("comments")
	public CommentDto findComments(@RequestParam(name = "productId", required = false, defaultValue = "0") int productId,
									@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		return reservationService.findComments(productId, start);
	}
	
	@ApiOperation(value = "예약 등록하기")
	@PostMapping("reservationinfos")
	public ReservationResponseDto RegisterReservations(@RequestBody ReservationRequestDto reservationRequest) {
		return reservationService.RegisterReservation(reservationRequest);
	}
	
	@ApiOperation(value = "주문 정보 구하기")
	@GetMapping("reservationinfos")
	public OrderInfosDto findOrderInfos(@ApiIgnore @AuthenticationPrincipal CustomUserDetails customUserDetails) {
		int userId = userService.getUserId(customUserDetails.getUsername());
		return reservationService.findOrderInfos(userId);
	}
	
	@ApiOperation(value = "예약 취소하기")
	@PutMapping("reservationinfos")
	public Map<String, String> cancelReservation(@RequestBody Map<String, Integer> params,
			@ApiIgnore @AuthenticationPrincipal CustomUserDetails customUserDetails){
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
	
	@ApiOperation(value = "댓글 등록하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "reservationInfoId", value = "reservationInfoId", paramType = "query", dataType = "int", required = true),
		@ApiImplicitParam(name = "score", value = "score", paramType = "query", dataType = "int", required = true),
		@ApiImplicitParam(name = "comment", value = "comment", paramType = "query", dataType = "string", required = true),
	})
	@PostMapping("comments")
	public CommentResponseDto RegisterComments(
			@ApiIgnore @AuthenticationPrincipal CustomUserDetails customUserDetails,
			@RequestParam(defaultValue = "0") int reservationInfoId,
			@RequestParam(defaultValue = "0") int score,
			@RequestParam(defaultValue = "0") String comment,
			@RequestParam(name = "multipartFile", required =  false) MultipartFile multipartFile) {
		int productId = reservationService.findProductId(reservationInfoId);
		int userId = userService.getUserId(customUserDetails.getUsername());
		if(score < 1 || score > 5){
			throw new RuntimeException("1점부터 5점 사이의 점수를 입력하시오");
		}
		return reservationService.RegisterComment(productId, reservationInfoId, userId, score, comment, multipartFile);
	}
}
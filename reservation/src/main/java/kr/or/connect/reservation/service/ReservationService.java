package kr.or.connect.reservation.service;

import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.domain.CommentDB;
import kr.or.connect.reservation.domain.CommentImageDB;
import kr.or.connect.reservation.domain.FileInfoDB;
import kr.or.connect.reservation.domain.ReservationInfoDB;
import kr.or.connect.reservation.domain.ReservationInfoPriceDB;
import kr.or.connect.reservation.domain.ReservationPriceRequest;
import kr.or.connect.reservation.dto.CategoryDto;
import kr.or.connect.reservation.dto.CommentDto;
import kr.or.connect.reservation.dto.CommentResponseDto;
import kr.or.connect.reservation.dto.DisplayInfosDto;
import kr.or.connect.reservation.dto.OrderInfosDto;
import kr.or.connect.reservation.dto.DisplayInfoDto;
import kr.or.connect.reservation.dto.PromotionDto;
import kr.or.connect.reservation.dto.ReservationRequestDto;
import kr.or.connect.reservation.dto.ReservationResponseDto;

public interface ReservationService {
	static final Integer DISPLAY_INFO_LIMIT = 4;
	static final Integer COMMENT_LIMIT = 5;
	CategoryDto findCategories();
	DisplayInfosDto findDisplayInfos(int categoryId, int start);
	PromotionDto findPromotions();
	DisplayInfoDto findDisplayInfo(int displayInfoId);
	CommentDto findComments(int productId, int start);
	ReservationResponseDto RegisterReservation(ReservationRequestDto reservationRequest);
	ReservationInfoDB addReservationInfoDB(ReservationRequestDto reservationRequest);
	ReservationInfoPriceDB addReservationInfoPriceDB(int reservationInfoId, ReservationPriceRequest reservationPriceRequest);
	OrderInfosDto findOrderInfos(int userId);
	int updateReservation(int reservationId, int userId);
	int findProductId(int reservationInfoId);
	CommentResponseDto RegisterComment(
			int productId, int reservationInfoId, int userId, int score, String comment, MultipartFile multipartFile);
	CommentDB addCommentDB(int productId, int reservationInfoId, int userId, int score, String comment);
	FileInfoDB addFileInfoDB(MultipartFile multipartFile);
	CommentImageDB addCommentImageDB(int reservationInfoId, int reservationUserCommentId, int fileId);
	void upload(MultipartFile file);
	String findFileName(int fileId);
	String findSaveFileName(int fileId);
	String findContentType(int fileId);
}
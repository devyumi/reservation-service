package kr.or.connect.reservation.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.or.connect.reservation.domain.ReservationPriceResponse;

public class ReservationResponseDto {
	private int id;
	private int productId;
	private int cancelFlag;
	private int displayInfoId;
	private int userId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime reservationDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyDate;
	List<ReservationPriceResponse> prices;
	
	public ReservationResponseDto() {
		
	}
	
	public ReservationResponseDto(int id, int productId, int cancelFlag, int displayInfoId, int userId,
			LocalDateTime reservationDate, LocalDateTime createDate, LocalDateTime modifyDate,
			List<ReservationPriceResponse> prices) {
		super();
		this.id = id;
		this.productId = productId;
		this.cancelFlag = cancelFlag;
		this.displayInfoId = displayInfoId;
		this.userId = userId;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.prices = prices;
	}
	
	public int getId() {
		return id;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getCancelFlag() {
		return cancelFlag;
	}
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	public List<ReservationPriceResponse> getPrices() {
		return prices;
	}
	
	@Override
	public String toString() {
		return "ReservationResponseDto [id=" + id + ", productId=" + productId + ", cancelFlag=" + cancelFlag
				+ ", displayInfoId=" + displayInfoId + ", userId=" + userId + ", reservationDate=" + reservationDate
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", prices=" + prices + "]";
	}
}
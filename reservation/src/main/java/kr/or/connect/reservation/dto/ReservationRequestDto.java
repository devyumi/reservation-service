package kr.or.connect.reservation.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.or.connect.reservation.domain.ReservationPriceRequest;

public class ReservationRequestDto {
	private List<ReservationPriceRequest> prices;
	private int productId;
	private int displayInfoId;
	@JsonFormat(pattern = "yyyy.MM.dd")
	private LocalDate reservationYearMonthDay;
	private int userId;
	
	public ReservationRequestDto() {
		
	}
	
	public ReservationRequestDto(List<ReservationPriceRequest> prices, int productId, int displayInfoId,
			LocalDate reservationYearMonthDay, int userId) {
		super();
		this.prices = prices;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.reservationYearMonthDay = reservationYearMonthDay;
		this.userId = userId;
	}
	
	public List<ReservationPriceRequest> getPrices() {
		return prices;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	
	public LocalDate getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}
	
	public int getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "ReservationRequestDto [prices=" + prices + ", productId=" + productId + ", displayInfoId="
				+ displayInfoId + ", reservationYearMonthDay=" + reservationYearMonthDay + ", userId=" + userId + "]";
	}
}
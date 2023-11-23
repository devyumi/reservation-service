package kr.or.connect.reservation.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationInfoDB {
	private int id;
	private int productId;
	private int displayInfoId;
	private int userId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime reservationDate;
	private int cancelFlag;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyDate;
	
	public ReservationInfoDB() {
		
	}
	
	public ReservationInfoDB(int productId, int displayInfoId, int userId, LocalDateTime reservationDate,
			int cancelFlag, LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.userId = userId;
		this.reservationDate = reservationDate;
		this.cancelFlag = cancelFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}
	
	public int getProductId() {
		return productId;
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
	
	public int getCancelFlag() {
		return cancelFlag;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	@Override
	public String toString() {
		return "ReservationInfoDB [id=" + id + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", userId=" + userId + ", reservationDate=" + reservationDate + ", cancelFlag=" + cancelFlag
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
}

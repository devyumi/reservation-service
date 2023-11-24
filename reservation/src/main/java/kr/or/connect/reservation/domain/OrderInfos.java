package kr.or.connect.reservation.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInfos {
	private int id;
	private int productId;
	private int displayInfoId;
	private int cancelFlag;
	private String productDescription;
	private String productContent;
	private int userId;
	private int sumPrice;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime reservationDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyDate;
	
	public OrderInfos() {
		super();
	}
	
	public OrderInfos(int id, int productId, int displayInfoId, int cancelFlag, String productDescription,
			String productContent, int userId, int sumPrice, LocalDateTime reservationDate, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.cancelFlag = cancelFlag;
		this.productDescription = productDescription;
		this.productContent = productContent;
		this.userId = userId;
		this.sumPrice = sumPrice;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "OrderInfos [id=" + id + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", cancelFlag=" + cancelFlag + ", productDescription=" + productDescription + ", productContent="
				+ productContent + ", userId=" + userId + ", sumPrice=" + sumPrice + ", reservationDate="
				+ reservationDate + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
}
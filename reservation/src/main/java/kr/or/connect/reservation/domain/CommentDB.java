package kr.or.connect.reservation.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDB {
	private int id;
	private int productId;
	private int reservationInfoId;
	private int userId;
	private int score;
	private String comment;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyDate;
	
	public CommentDB() {
		super();
	}
	
	public CommentDB(int productId, int reservationInfoId, int userId, int score, String comment,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.userId = userId;
		this.score = score;
		this.comment = comment;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getComment() {
		return comment;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	@Override
	public String toString() {
		return "CommentDB [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", userId=" + userId + ", score=" + score + ", comment=" + comment + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
}
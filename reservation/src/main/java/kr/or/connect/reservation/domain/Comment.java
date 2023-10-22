package kr.or.connect.reservation.domain;

import java.util.List;

public class Comment {
	private int id;
	private int productId;
	private int reservationInfoId;
	private double score;
	private String reservationEmail;
	private String comment;
	private String createDate;
	private String modifyDate;
	private List<String> reservationUserCommentImages;
	
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
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getReservationEmail() {
		return reservationEmail;
	}
	
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public List<String> getReservationUserCommentImages() {
		return reservationUserCommentImages;
	}
	
	public void setReservationUserCommentImages(List<String> reservationUserCommentImages) {
		this.reservationUserCommentImages = reservationUserCommentImages;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", reservationEmail=" + reservationEmail + ", comment=" + comment
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", reservationUserCommentImages="
				+ reservationUserCommentImages + "]";
	}
}

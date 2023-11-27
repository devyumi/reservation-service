package kr.or.connect.reservation.domain;

import java.util.List;

public class Comment {
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private int userId;
	private String comment;
	private List<CommentImage> reservationUserCommentImages;
	
	public Comment() {
		super();
	}

	public Comment(int id, int productId, int reservationInfoId, int score, int userId, String comment,
			List<CommentImage> reservationUserCommentImages) {
		super();
		this.id = id;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.userId = userId;
		this.comment = comment;
		this.reservationUserCommentImages = reservationUserCommentImages;
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
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<CommentImage> getReservationUserCommentImages() {
		return reservationUserCommentImages;
	}
	
	public void setReservationUserCommentImages(List<CommentImage> reservationUserCommentImages) {
		this.reservationUserCommentImages = reservationUserCommentImages;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", userId=" + userId + ", comment=" + comment + ", reservationUserCommentImages="
				+ reservationUserCommentImages + "]";
	}
}
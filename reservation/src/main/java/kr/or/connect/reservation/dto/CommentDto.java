package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.Comment;

public class CommentDto {
	private int totalCount;
	private int commentCount;
	private List<Comment> reservationUserComments;
	
	public CommentDto() {
		
	}
	
	public CommentDto(int totalCount, int commentCount, List<Comment> reservationUserComments) {
		super();
		this.totalCount = totalCount;
		this.commentCount = commentCount;
		this.reservationUserComments = reservationUserComments;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	public List<Comment> getReservationUserComments() {
		return reservationUserComments;
	}
	
	public void setReservationUserComments(List<Comment> reservationUserComments) {
		this.reservationUserComments = reservationUserComments;
	}
	
	@Override
	public String toString() {
		return "CommentDto [totalCount=" + totalCount + ", commentCount=" + commentCount + ", reservationUserComments="
				+ reservationUserComments + "]";
	}
}

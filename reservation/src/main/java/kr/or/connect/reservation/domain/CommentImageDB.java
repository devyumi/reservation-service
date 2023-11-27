package kr.or.connect.reservation.domain;

public class CommentImageDB {
	private int id;
	private int reservationInfoId;
	private int reservationUserCommentId;
	private int fileId;
	
	public CommentImageDB() {
		super();
	}
	
	public CommentImageDB(int reservationInfoId, int reservationUserCommentId, int fileId) {
		super();
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fileId;
	}
	
	public int getId() {
		return id;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	
	public int getFileId() {
		return fileId;
	}
	
	@Override
	public String toString() {
		return "CommentImageDB [id=" + id + ", reservationInfoId=" + reservationInfoId + ", reservationUserCommentId="
				+ reservationUserCommentId + ", fileId=" + fileId + "]";
	}
}
package kr.or.connect.reservation.domain;

public class ReservationInfoPriceDB {
	private int id;
	private int reservationInfoId;
	private int productPriceId;
	private int count;
	
	public ReservationInfoPriceDB() {
		
	}
	
	public ReservationInfoPriceDB(int reservationInfoId, int productPriceId, int count) {
		super();
		this.reservationInfoId = reservationInfoId;
		this.productPriceId = productPriceId;
		this.count = count;
	}
	
	public int getId() {
		return id;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public int getProductPriceId() {
		return productPriceId;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return "ReservationInfoPriceDB [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId="
				+ productPriceId + ", count=" + count + "]";
	}
}
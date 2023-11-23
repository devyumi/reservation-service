package kr.or.connect.reservation.domain;

public class ReservationPriceResponse {
	private int id;
	private int reservationInfoId;
	private int productPriceId;
	private int count;
	
	public ReservationPriceResponse() {
		
	}
	
	public ReservationPriceResponse(int id, int reservationInfoId, int productPriceId, int count) {
		super();
		this.id = id;
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
		return "ReservationPriceResponse [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId="
				+ productPriceId + ", count=" + count + "]";
	}
}
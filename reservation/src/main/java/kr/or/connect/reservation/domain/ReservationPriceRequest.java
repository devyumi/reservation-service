package kr.or.connect.reservation.domain;

public class ReservationPriceRequest {
	private int count;
	private int productPriceId;
	
	public ReservationPriceRequest() {
		
	}
	
	public ReservationPriceRequest(int count, int productPriceId) {
		super();
		this.count = count;
		this.productPriceId = productPriceId;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getProductPriceId() {
		return productPriceId;
	}
	
	@Override
	public String toString() {
		return "ReservationPriceRequest [count=" + count + ", productPriceId=" + productPriceId + "]";
	}
}
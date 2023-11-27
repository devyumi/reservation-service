package kr.or.connect.reservation.dto;

public class CommentResponseDto {
	private String result;
	private int productId;
	
	public CommentResponseDto() {
		super();
	}
	
	public CommentResponseDto(String result, int productId) {
		super();
		this.result = result;
		this.productId = productId;
	}
	
	public String getResult() {
		return result;
	}
	
	public int getProductId() {
		return productId;
	}
	
	@Override
	public String toString() {
		return "CommentResponseDto [result=" + result + ", productId=" + productId + "]";
	}
}
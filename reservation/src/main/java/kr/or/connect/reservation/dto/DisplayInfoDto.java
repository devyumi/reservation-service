package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.DisplayInfo;

public class DisplayInfoDto {
	private int totalCount;
	private int productCount;
	private List<DisplayInfo> products;
	
	public DisplayInfoDto() {
		
	}
	
	public DisplayInfoDto(int totalCount, int productCount, List<DisplayInfo> products) {
		super();
		this.totalCount = totalCount;
		this.productCount = productCount;
		this.products = products;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getProductCount() {
		return productCount;
	}

	public List<DisplayInfo> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "DisplayInfoDto [totalCount=" + totalCount + ", productCount=" + productCount + ", products=" + products
				+ "]";
	}
}

package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.DisplayInfos;

public class DisplayInfosDto {
	private int totalCount;
	private int productCount;
	private List<DisplayInfos> products;
	
	public DisplayInfosDto() {
		
	}
	
	public DisplayInfosDto(int totalCount, int productCount, List<DisplayInfos> products) {
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

	public List<DisplayInfos> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "DisplayInfosDto [totalCount=" + totalCount + ", productCount=" + productCount + ", products=" + products
				+ "]";
	}
}

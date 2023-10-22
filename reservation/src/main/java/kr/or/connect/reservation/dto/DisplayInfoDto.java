package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.DisplayInfos;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;

public class DisplayInfoDto {

	private List<DisplayInfos> product;
	private List<ProductImage> productImages;
	private List<DisplayInfoImage> displayInfoImages;
	private int avgScore;
	private List<ProductPrice> productPrices;
	
	public DisplayInfoDto() {
		
	}
	
	public DisplayInfoDto(List<DisplayInfos> product, List<ProductImage> productImages,
			List<DisplayInfoImage> displayInfoImages, int avgScore, List<ProductPrice> productPrices) {
		super();
		this.product = product;
		this.productImages = productImages;
		this.displayInfoImages = displayInfoImages;
		this.avgScore = avgScore;
		this.productPrices = productPrices;
	}

	public List<DisplayInfos> getProduct() {
		return product;
	}
	
	public List<ProductImage> getProductImages() {
		return productImages;
	}
	
	public List<DisplayInfoImage> getDisplayInfoImages() {
		return displayInfoImages;
	}
	
	public int getAvgScore() {
		return avgScore;
	}
	
	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}
	
	@Override
	public String toString() {
		return "DisplayInfoDto [product=" + product + ", productImages=" + productImages
				+ ", displayInfoImages=" + displayInfoImages + ", avgScore=" + avgScore + ", productPrices="
				+ productPrices + "]";
	}
}
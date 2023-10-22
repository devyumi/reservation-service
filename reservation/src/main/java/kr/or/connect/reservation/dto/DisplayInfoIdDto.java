package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.DisplayInfo;
import kr.or.connect.reservation.domain.DisplayInfoImage;
import kr.or.connect.reservation.domain.ProductImage;
import kr.or.connect.reservation.domain.ProductPrice;

public class DisplayInfoIdDto {

	private List<DisplayInfo> product;
	private List<ProductImage> productImages;
	private List<DisplayInfoImage> displayInfoImages;
	private double avgScore;
	private List<ProductPrice> productPrices;
	
	public DisplayInfoIdDto() {
		
	}
	
	public DisplayInfoIdDto(List<DisplayInfo> product, List<ProductImage> productImages,
			List<DisplayInfoImage> displayInfoImages, double avgScore, List<ProductPrice> productPrices) {
		super();
		this.product = product;
		this.productImages = productImages;
		this.displayInfoImages = displayInfoImages;
		this.avgScore = avgScore;
		this.productPrices = productPrices;
	}

	public List<DisplayInfo> getProduct() {
		return product;
	}
	
	public List<ProductImage> getProductImages() {
		return productImages;
	}
	
	public List<DisplayInfoImage> getDisplayInfoImages() {
		return displayInfoImages;
	}
	
	public double getAvgScore() {
		return avgScore;
	}
	
	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}
	
	@Override
	public String toString() {
		return "DisplayInfoIdDto [product=" + product + ", productImages=" + productImages
				+ ", displayInfoImages=" + displayInfoImages + ", avgScore=" + avgScore + ", productPrices="
				+ productPrices + "]";
	}
}
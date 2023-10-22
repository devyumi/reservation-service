package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.Promotion;

public class PromotionDto {
	private int size;
	private List<Promotion> items;
	
	public PromotionDto() {
		
	}
	
	public PromotionDto(int size, List<Promotion> items) {
		super();
		this.size = size;
		this.items = items;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public List<Promotion> getItems() {
		return items;
	}
	
	public void setItems(List<Promotion> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "PromotionDto [size=" + size + ", items=" + items + "]";
	}
}

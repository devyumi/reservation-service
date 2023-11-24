package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.OrderInfos;

public class OrderInfosDto {
	private int size;
	private List<OrderInfos> items;
	
	public OrderInfosDto() {
		super();
	}
	
	public OrderInfosDto(int size, List<OrderInfos> items) {
		super();
		this.size = size;
		this.items = items;
	}
	
	public int getSize() {
		return size;
	}
	
	public List<OrderInfos> getItems() {
		return items;
	}
	
	@Override
	public String toString() {
		return "OrderInfosDto [size=" + size + ", items=" + items + "]";
	}
}
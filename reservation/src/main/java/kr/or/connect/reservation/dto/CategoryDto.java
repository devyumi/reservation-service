package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.Category;

public class CategoryDto {
	private int size;
	private List<Category> items;
	
	public CategoryDto() {
		
	}
	
	public CategoryDto(int size, List<Category> categories) {
		this.size = size;
		this.items = categories;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Category> getItems() {
		return items;
	}

	public void setItems(List<Category> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CategoryDto [size=" + size + ", items=" + items + "]";
	}
}
package com.db.jdbc.dao.model;

public class Category {

	private Long id;
	private String category_name;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String name) {
		this.category_name = name;
	}

	@Override
	public String toString() {
		return "Category [categoria=" + category_name + "]";
	}

}

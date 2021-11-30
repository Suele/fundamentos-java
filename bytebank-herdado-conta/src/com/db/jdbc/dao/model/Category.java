package com.db.jdbc.dao.model;

public class Category {

	private Long id;
	private String category_name;

	public Category() {
	}

	public Category(Long id, String categoryName) {
		this.id = id;
		this.category_name = categoryName;
	}

	public Category(String categoryName) {
		this.category_name = categoryName;
	}

	public Long getId() {
		return this.id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String name) {
		this.category_name = name;
	}

	@Override
	public String toString() {
		return category_name;
	}

}

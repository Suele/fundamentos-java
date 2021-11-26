package com.db.jdbc.dao.model;

public class Product {

	private Long id;
	private String name;
	private String description;

	public Product(String name, String description) {
		if (name != null && description != null) {
			this.name = name;
			this.description = description;
		} else {
			System.out.println("Nome ou descrição estão nulos.");
		}

	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + "]";
	}

}

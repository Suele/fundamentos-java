package com.db.jdbc.dao.model;

public class Product {

	private Long id;
	private String product_name;
	private String description;
	private Category category = new Category();

	public Product(String name, String description) {
		if (name != null && description != null) {
			this.product_name = name;
			this.description = description;
		} else {
			System.out.println("Nome ou descrição estão nulos.");
		}
	}

	public Product(String categoryName, String name, String description) {
		this.category.setCategory_name(categoryName);
		this.product_name = name;
		this.description = description;
	}

	public String getName() {
		return getProduct_name();
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return this.category.getCategory_name();
	}

	@Override
	public String toString() {
		if (this.getCategory() == null) {
			return "Product [product_name=" + product_name + ", description=" + description + "]";
		} else {
			return "Product [product_name=" + product_name + ", description=" + description + ", categoria= "
					+ this.getCategory() + "]";
		}

	}

	public void setCategoriaId(Long id2) {
		// TODO Auto-generated method stub

	}

}

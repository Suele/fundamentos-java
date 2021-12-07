package model;

import javax.persistence.*;

@Entity(name = "ProductModel")
@Table(name = "product")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	private String description;

	@ManyToOne
	private CategoryModel category;

	public ProductModel() {
	}


	public ProductModel(String productName, String description, CategoryModel category) {
		this.productName = productName;
		this.description = description;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product{" + "id:" + this.getId() + ", productName:'" + this.getProductName() + '\'' + ", description:'" + this.getDescription() + '\'' + this.category + '}';
	}
}
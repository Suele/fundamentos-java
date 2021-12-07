package model;

import javax.persistence.*;

@Entity(name = "CategoryModel")
@Table(name = "category")
public class CategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "category_name")
	private String categoryName;

	public CategoryModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return ", Category{" + "id:" + this.getId() + ", categoryName:'" + this.categoryName + '\'' + '}';
	}
}

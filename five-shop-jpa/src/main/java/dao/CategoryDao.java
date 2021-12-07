package dao;

import model.CategoryModel;

import javax.persistence.EntityManager;

public class CategoryDao {
	private final EntityManager entityManager;

	public CategoryDao(EntityManager em) {
		this.entityManager = em;
	}

	public void insertCategory(CategoryModel category) {
		this.entityManager.persist(category);
	}
}

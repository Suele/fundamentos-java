package dao;

import model.CategoryModel;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {
	private final EntityManager entityManager;

	public CategoryDao(EntityManager em) {
		this.entityManager = em;
	}

	public void insertCategory(CategoryModel category) {
		this.entityManager.persist(category);
	}

	public List<CategoryModel> listCategory() {
		String jpql = "SELECT c.id, c.category_name  FROM category c";
		return this.entityManager.createNativeQuery(jpql, CategoryModel.class).getResultList();
	}

	public CategoryModel findId(Long categoryId) {
		return this.entityManager.find(CategoryModel.class, categoryId);
	}
}

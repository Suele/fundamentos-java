package dao;

import model.ProductModel;

import javax.persistence.EntityManager;
import java.util.List;

/*
 * Classe utilizada para persistir dados(insert, update e delete)
 * e consultar dados(select, busca um produto(objeto) pelo id)
 * */

public class ProductDao {
	private EntityManager entityManager;

	public ProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertProduct(ProductModel product) {
		this.entityManager.persist(product);
	}

	public List<ProductModel> selectProduct() {
		String jpql = "SELECT p.id, p.product_name, p.description, p.category_id FROM product p";
		return this.entityManager.createNativeQuery(jpql, ProductModel.class).getResultList();
	}

	public ProductModel findId(Long productId) {
		return this.entityManager.find(ProductModel.class, productId);
	}

	public void deleteProduct(ProductModel product) {
		this.entityManager.remove(product);
		this.entityManager.flush();
	}

	public List<ProductModel> findProductName(String product_name) {
		String queryJPQL = " SELECT p.id, p.product_name, p.description, p.category_id FROM product p WHERE p.product_name = :product_name";
		return this.entityManager.createNativeQuery(queryJPQL, ProductModel.class).setParameter("product_name", product_name).getResultList();
	}
}
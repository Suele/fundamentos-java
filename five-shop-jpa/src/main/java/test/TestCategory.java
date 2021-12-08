package test;

import dao.CategoryDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCategory {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("five-shop-persistence");
		EntityManager em = factory.createEntityManager();

		//Abre transação com o banco de dados.
		em.getTransaction().begin();

		CategoryDao categoryDao = new CategoryDao(em);
		System.out.println(categoryDao.listCategory());

		em.getEntityManagerFactory().close();
		factory.close();
		em.close();
	}
}
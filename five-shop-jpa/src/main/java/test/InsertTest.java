package test;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryModel;
import model.ProductModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertTest {
	public static void main(String[] args) {

		CategoryModel newCategory = new CategoryModel();
		newCategory.setName("smartphone");

		// Instancia o objeto produto e adiciona os atributos.
		ProductModel newProduct = new ProductModel("smartphone samsung", " cor dourado tela de 14", newCategory);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("five-shop-persistence");
		EntityManager em = factory.createEntityManager();

		// Abre transação com o banco de dados.
		em.getTransaction().begin();
		// Persiste o dados ou seja altera um dado ou cria um novo.
		CategoryDao categoryDao = new CategoryDao(em);
		ProductDao productDao = new ProductDao(em);

		//categoryDao.insertCategory(newCategory);
		//productDao.insertProduct(newProduct);
		//System.out.println(productDao.selectProduct());

		//System.out.println(productDao.findId(26L));

		productDao.deleteProduct(productDao.findId(15L));

		// Autoriza a alteração
		em.getTransaction().commit();
		// Encerra a transação.
		em.close();
	}
}

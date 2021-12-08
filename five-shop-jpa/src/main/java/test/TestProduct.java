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

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("five-shop-persistence");
		EntityManager em = factory.createEntityManager();


		CategoryDao categoryDao = new CategoryDao(em);
		ProductDao productDao = new ProductDao(em);

		// Instancia o objeto produto e adiciona os atributos.
		ProductModel newProduct = new ProductModel("smartphone samsung", " cor dourado tela de 14", categoryDao.findId(3L));

		//Abre transação com o banco de dados.
		em.getTransaction().begin();

		//Adiciona  uma nova categoria no banco de dados.
		categoryDao.insertCategory(newCategory);

		//Adiciona um produto na base de dados.
		productDao.insertProduct(newProduct);

		//Busca todos os produtos que estejam na base de dados.
		System.out.println(productDao.selectProduct());

		//Busca produto pelo id.
		//System.out.println(productDao.findId(26L));

		// Deleta produto pelo id.
		//productDao.deleteProduct(productDao.findId(1L));

		// Autoriza a alteração
		em.getTransaction().commit();
		em.getEntityManagerFactory().close();
		// Encerra a transação.
		em.close();
	}
}

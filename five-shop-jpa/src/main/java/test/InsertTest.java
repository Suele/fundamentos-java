package test;

import model.ProductModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertTest {
	public static void main(String[] args) {
		// Instancia o objeto produto e adiciona os atributos.
		ProductModel newProduct = new ProductModel();
		newProduct.setProductName("phone xaomi");
		newProduct.setDescription("smartphone cor preto tela de 12");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("five-shop-persistence");

		EntityManager em = factory.createEntityManager();

		// Abre transação com o banco de dados.
		em.getTransaction().begin();
		// Persiste o dados ou seja altera um dado ou cria um novo.
		em.persist(newProduct);
		// Autoriza a alteração
		em.getTransaction().commit();
		// Encerra a transação.
		em.close();
	}
}

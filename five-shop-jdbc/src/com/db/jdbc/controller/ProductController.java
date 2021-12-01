package com.db.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.db.jdbc.dao.ConnectionFactory;
import com.db.jdbc.dao.ProductDao;
import com.db.jdbc.dao.model.Product;

public class ProductController {

	private Connection connection;

	public ProductController() throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory("root", "senha");
		this.connection = connectionFactory.criaConexao();
	}

	public void deletar(Integer id) {
		System.out.println("Deletando produto");
	}

	public void salvar(Product produto) throws SQLException {
		ProductDao productDao = new ProductDao(this.connection);
		productDao.save(produto);
	}

	public List<Product> listar() throws SQLException {
		ProductDao productDao = new ProductDao(this.connection);
		return productDao.productAndCategory();
	}

	public void alterar(String nome, String descricao, Integer id) {
		System.out.println("Alterando produto");
	}
}

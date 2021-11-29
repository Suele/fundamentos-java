package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.jdbc.dao.model.Product;

public class ProductDao {

	private Connection connection;

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<Product> listProduct() throws SQLException {
		// executa SELECT na tabela cliente.
		PreparedStatement stm = connection.prepareStatement("SELECT product_name, description FROM product");
		stm.execute();

		List<Product> products = new ArrayList<Product>();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Product product = new Product(rlt.getNString("product_name"), rlt.getNString("description"));
			products.add(product);
		}

		return products;
	}

	public List<Product> productAndCategory() throws SQLException {
		List<Product> products = new ArrayList<Product>();

		String joinCategoryAndProduct = ("SELECT c.category_name, p.product_name, p.description FROM category c INNER JOIN "
				+ "product p ON c.id = p.category_id" + " ORDER BY p.category_id");

		PreparedStatement stm = connection.prepareStatement(joinCategoryAndProduct);

		stm.execute();

		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Product product = new Product(rlt.getNString("category_name"), rlt.getNString("product_name"),
					rlt.getNString("description"));
			products.add(product);
		}
		return products;
	}
}

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
		PreparedStatement stm = connection.prepareStatement("SELECT name, description FROM product");
		stm.execute();

		List<Product> products = new ArrayList<Product>();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Product product = new Product(rlt.getNString("name"), rlt.getNString("description"));
			products.add(product);
		}

		return products;
	}
}

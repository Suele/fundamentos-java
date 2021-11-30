package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.jdbc.dao.model.Category;

public class CategoryDao {

	private Connection connection;

	public CategoryDao(Connection connection) {
		this.connection = connection;
	}

	public List<Category> listCategory() throws SQLException {
		List<Category> categories = new ArrayList<>();

		PreparedStatement stm = this.connection.prepareStatement("SELECT category_name FROM category");
		stm.execute();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Category category = new Category(rlt.getNString("category_name"));
			categories.add(category);
		}

		return categories;
	}

}

package com.db.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.db.jdbc.dao.CategoryDao;
import com.db.jdbc.dao.ConnectionFactory;
import com.db.jdbc.dao.model.Category;

public class CategoryController {

	public List<Category> listar() throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory("root", "senha");
		Connection connection = connectionFactory.criaConexao();

		CategoryDao categoryDao = new CategoryDao(connection);
		return categoryDao.listCategory();
	}
}

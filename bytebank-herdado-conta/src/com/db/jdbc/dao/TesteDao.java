package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.jdbc.dao.model.Customer;

public class TesteDao {
	public static void main(String[] args) throws SQLException {

		Customer customer = new Customer("Bloguerinha", "66666666666", "YouTuber");

		ConnectionFactory connectionFactory = new ConnectionFactory("root", "senha");
		Connection connection = connectionFactory.criaConexao();

		CustomerDao customerDao = new CustomerDao(connection);
		customerDao.salvar(customer);
		customerDao.buscar();

		connection.close();
	}

}

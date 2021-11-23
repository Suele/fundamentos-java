package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.jdbc.dao.model.Cliente;

public class TesteDao {
	public static void main(String[] args) throws SQLException {

		Cliente cliente = new Cliente("Bloguerinha", "13131313131", "YouTuber");

		ConnectionFactory connectionFactory = new ConnectionFactory("root", "senha");
		Connection connection = connectionFactory.criaConexao();

		ClienteDao clienteDao = new ClienteDao(connection);
		clienteDao.salvar(cliente);
		clienteDao.buscar();

		connection.close();
	}

}

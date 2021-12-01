package com.db.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author suele
 *
 */
public class ConexãoBancoDados {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionBD = new ConnectionFactory();
		Connection connection = connectionBD.criaConexao("root", "senha");

		System.out.println("Conexão com o banco de dados MYSQL criada");

		connection.close();
	}

}

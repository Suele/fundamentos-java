package com.db.jdbc.poolConnection;

import java.sql.SQLException;

public class TestaPoolConexao {

	public static void main(String[] args) throws SQLException {

		// conecta no banco de dados.
		ConnectionFactory connectionFactory = new ConnectionFactory("root", "senha");

		for (int i = 0; i <= 20; i++) {
			connectionFactory.criaConexao();
			System.out.println(i);
		}
	}

}

package com.db.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertBD {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		String nome = "Vando";
		String cpf = "77777777777";
		String profissao = "Motorista";

		PreparedStatement preparedStatement = connection.prepareStatement(
				" INSERT INTO cliente(nome, cpf, profissao) VALUES(?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, cpf);
		preparedStatement.setString(3, profissao);

		// o execute retorna false pq é uma execução que não busca nada no bd.
		preparedStatement.execute();

		// retorna objeto contendo o id do novo cliente.
		ResultSet rts = preparedStatement.getGeneratedKeys();

		while (rts.next()) {
			Integer id = rts.getInt(1);
			System.out.println("id: " + id);
		}

		connection.close();
	}

}

package com.db.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author suele
 *
 */

/**
 * Injeção de SQL é uma prática utilizada para inserir query SQL em formularios
 * por exemplo, podendo assim excluir ou atualizar um dado.
 */

public class EvitandoSQLInjection {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		String nome = "Suara";
		String cpf = "55555555555";
		String profissao = "Professora";

		PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO cliente(nome, cpf, profissao) VALUES(?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, cpf);
		preparedStatement.setString(3, profissao);

		preparedStatement.execute();

		ResultSet generate = preparedStatement.getGeneratedKeys();

		while (generate.next()) {
			Integer id = generate.getInt(1);
			System.out.println("id: " + id);
		}

		connection.close();
	}

}

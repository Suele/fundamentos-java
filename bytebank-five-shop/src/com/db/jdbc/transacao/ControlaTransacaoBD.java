package com.db.jdbc.transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Transações em BD commit - efetua a aleração no BD, que pode ser INSERIR um
 * dado. As transações em BD devem ser atomicas(ou faz tudo que deve ser feito,
 * ou retorna tudo como estava antes). 
 * -commit - faz as alterações.
 * -rollback - retorna tudo para o estado anterior se houve uma mudança(desfaz o que foi
 * feito)
 */

public class ControlaTransacaoBD {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		// abre conexão com o banco de dados.
		Connection connection = connectionFactory.criaConexao("root", "senha");

		// retira o controle de INSERIR, DELETAR ou fazer UPDATE do JDBC.
		// para controlar a transação com o banco de dados.
		connection.setAutoCommit(false);

		try {
			// pode ser executado um INSERT, DELETE, SELECT ou UPDATE.
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO cliente(nome, cpf, profissao) VALUES(?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			adicionaValores("Amanda", "88888888888", "Comunicadora", preparedStatement, connection);
			adicionaValores("Sergio", "99999999999", "Comunicador", preparedStatement, connection);
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("Transação não foi realizada.");
		}
		// fecha conexão com o BD.
		connection.close();
	}

	private static void adicionaValores(String nome, String cpf, String profissao, PreparedStatement preparedStatement,
			Connection connection) throws SQLException {
		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, cpf);
		preparedStatement.setString(3, profissao);

		preparedStatement.execute();

		ResultSet generate = preparedStatement.getGeneratedKeys();

		while (generate.next()) {
			Integer id = generate.getInt(1);
			System.out.println("id: " + id);
		}
	}

}

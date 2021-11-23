package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.jdbc.dao.model.Cliente;

public class ClienteDao {

	private Connection connection;

	public ClienteDao(Connection connection) {
		this.connection = connection;

	}

	public void salvar(Cliente cliente) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				" INSERT INTO cliente(nome, cpf, profissao) VALUES(?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, cliente.getNome());
		preparedStatement.setString(2, cliente.getCpf());
		preparedStatement.setString(3, cliente.getProfissao());

		// o execute retorna false pq é uma execução que não busca nada no bd.
		preparedStatement.execute();

		// retorna objeto contendo o id do novo cliente.
		ResultSet rts = preparedStatement.getGeneratedKeys();

		while (rts.next()) {
			Integer id = rts.getInt(1);
			System.out.println("id: " + id);
		}

	}

	public void buscar() throws SQLException {
		// executa SELECT na tabela cliente.
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, CPF, PROFISSAO FROM cliente");
		stm.execute();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Integer id = rlt.getInt("ID");
			System.out.println(id);

			String name = rlt.getNString("NOME");
			System.out.println(name);

			String cpf = rlt.getNString("CPF");
			System.out.println(cpf);

			String profissao = rlt.getNString("PROFISSAO");
			System.out.println(profissao);
		}

	}

}

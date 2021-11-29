package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.jdbc.dao.model.Customer;

public class CustomerDao {

	private Connection connection;

	public CustomerDao(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Customer custome) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				" INSERT INTO customer(name, cpf, occupation) VALUES(?, ?, ?)",
				PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setString(1, custome.getName());
		preparedStatement.setString(2, custome.getCpf());
		preparedStatement.setString(3, custome.getOccupation());

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
		PreparedStatement stm = connection.prepareStatement("SELECT id, name, cpf, occupation FROM customer");
		stm.execute();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		while (rlt.next()) {
			Integer id = rlt.getInt("id");
			System.out.println(id);

			String name = rlt.getNString("name");
			System.out.println(name);

			String cpf = rlt.getNString("cpf");
			System.out.println(cpf);

			String occupation = rlt.getNString("occupation");
			System.out.println(occupation);
		}

	}

}

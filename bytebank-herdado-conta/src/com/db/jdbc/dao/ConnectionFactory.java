package com.db.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Pool Conexão Como é custoso abrir e fechar conexões com o BD é comum ter um
 * numero x de conexões já abertas esperando requisições dos usuarios.
 **/

public class ConnectionFactory {
	public DataSource dataSource;

	public ConnectionFactory(String user, String password) {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		comboPooledDataSource.setMinPoolSize(5);
		comboPooledDataSource.setMaxPoolSize(15);

		this.dataSource = comboPooledDataSource;
	}

	public Connection criaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

}

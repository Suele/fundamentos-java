package com.db.jdbc.poolConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ConnectionFactory é uma fabrica de conexão para o BD. e neste fabrica de
 * conexão tem um pool de conexão. onde é possivel ter uma varias conexões com o
 * BD abertas. antes tinhamos somente uma.
 **/

public class ConnectionFactory {
	public DataSource dataSource;

	public ConnectionFactory(String user, String password) {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		this.dataSource = comboPooledDataSource;
	}

	public Connection criaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

}

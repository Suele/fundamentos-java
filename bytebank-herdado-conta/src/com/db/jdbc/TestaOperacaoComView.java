package com.db.jdbc;

import java.sql.SQLException;

import javax.swing.JFrame;

import com.db.jdbc.view.ProdutoCategoriaFrame;

public class TestaOperacaoComView {

	public static void main(String[] args) throws SQLException {
		ProdutoCategoriaFrame produtoCategoriaFrame = new ProdutoCategoriaFrame();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

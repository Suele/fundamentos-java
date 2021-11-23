package com.db.jdbc.dao.model;

public class Cliente {
	private Long id;
	private String nome;
	private String cpf;
	private String profissao;

	public Cliente(String nome, String cpf, String profissao) {
		if (nome != null && cpf != null && profissao != null) {
			this.nome = nome;
			this.cpf = cpf;
			this.profissao = profissao;
		} else {
			System.out.println("Verifique se todos os campos estão preenchidos.");
		}
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getProfissao() {
		return this.profissao;
	}

}

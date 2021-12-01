package com.db.jdbc.dao.model;

public class Customer {
	private Long id;
	private String name;
	private String cpf;
	private String occupation;

	public Customer(String name, String cpf, String occupation) {
		if (name != null && cpf != null && occupation != null) {
			this.name = name;
			this.cpf = cpf;
			this.occupation = occupation;
		} else {
			System.out.println("Verifique se todos os campos estão preenchidos.");
		}
	}

	public String getName() {
		return this.name;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getOccupation() {
		return this.occupation;
	}

}

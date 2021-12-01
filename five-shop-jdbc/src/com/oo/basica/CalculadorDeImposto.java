package com.oo.basica;
public class CalculadorDeImposto {

	private double totalImposto;

	public void calculaTotalDeImpostos(Tributavel t) {

		double valor = t.impostoAPagar();
		this.totalImposto += valor;

	}

	public double getTotalImposto() {
		return totalImposto;
	}

}
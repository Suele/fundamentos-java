package com.oo.basica;

public class TesteTributaveis {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(330, 12111190);
		cc.deposita(5000.0);

		SeguroDeVida seguroDeVida = new SeguroDeVida();

		CalculadorDeImposto calculadorDeImposto = new CalculadorDeImposto();
		calculadorDeImposto.calculaTotalDeImpostos(cc);
		//calculadorDeImposto.calculaTotalDeImpostos(seguroDeVida);

		System.out.println(calculadorDeImposto.getTotalImposto());
	}

}

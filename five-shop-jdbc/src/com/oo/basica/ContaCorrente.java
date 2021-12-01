package com.oo.basica;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public boolean saca(double valor) {
		double valorComTaxa = valor + 10.0;
		return super.saca(valorComTaxa);
	}

	@Override
	public String toString() {
		return "ContaCorrente - Saldo=" + super.getSaldo() + ", Numero=" + super.getNumero() + ", Agencia="
				+ super.getAgencia() + ", Titular=" + super.getTitular().getNome();
	}

	@Override
	public double impostoAPagar() {
		return super.getSaldo() * 0.01;
	}

}

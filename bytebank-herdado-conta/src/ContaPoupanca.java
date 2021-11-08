
public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public String toString() {
		return "ContaPoupanca - Saldo=" + getSaldo() + ", Numero=" + getNumero() + ", Agencia=" + getAgencia()
				+ ", Titular=" + getTitular().getNome();
	}

}

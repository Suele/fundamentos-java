
public class TesteConta {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Suele");

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Maria");

		System.out.println();

		ContaCorrente contaCorrente = new ContaCorrente(330, 5490123);
		contaCorrente.deposita(100);
		contaCorrente.setTitular(cliente);
		System.out.println(contaCorrente.toString());

		System.out.println();

		ContaPoupanca contaPoupanca = new ContaPoupanca(330, 78912345);
		contaPoupanca.setTitular(cliente1);
		System.out.println(contaPoupanca.toString());

		contaCorrente.transfere(10.0, contaPoupanca);

		System.out.println();
		System.out.println("Conta Poupanca: " + contaPoupanca.getSaldo());
		System.out.println("Conta Corrente: " + contaCorrente.getSaldo());
	}

}
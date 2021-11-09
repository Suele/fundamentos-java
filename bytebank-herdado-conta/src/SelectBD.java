import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author suele
 *
 */
public class SelectBD {

	public static void main(String[] args) throws SQLException {

		// conecta no banco de dados.
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		System.out.println("Conectado no banco de dados.");

		// executa SELECT na tabela cliente.
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, CPF, PROFISSAO FROM cliente");
		stm.execute();

		// pega o resultado gerado na execução SQL.
		ResultSet rlt = stm.getResultSet();

		// enquanto tiver elementos na tabela CLIENTE, o laço será executado.
		while (rlt.next()) {
			Integer id = rlt.getInt("ID");
			System.out.println(id);

			String name = rlt.getNString("NOME");
			System.out.println(name);

			String cpf = rlt.getNString("CPF");
			System.out.println(cpf);

			String profissao = rlt.getNString("PROFISSAO");
			System.out.println(profissao);
		}

		// fecha a conexão com o banco de dados.
		connection.close();
	}

}

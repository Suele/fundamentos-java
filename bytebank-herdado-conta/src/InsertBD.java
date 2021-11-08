import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBD {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		Statement smt = connection.createStatement();
		smt.execute(" INSERT INTO cliente(nome, cpf, profissao) VALUES('Mariana', '33333333333', 'PO')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rts = smt.getGeneratedKeys();

		while (rts.next()) {
			Integer id = rts.getInt(1);
			System.out.println("id: " + id);
		}

		connection.close();
	}

}

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBD {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		Statement smt = connection.createStatement();

		smt.execute("DELETE FROM cliente WHERE ID = 3");

		Integer linhasModificadas = smt.getUpdateCount();

		System.out.println("Linhas alteradas: " + linhasModificadas);

		connection.close();
	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBD {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criaConexao("root", "senha");

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE ID = ?");
		
		preparedStatement.setInt(1, 12);

		preparedStatement.execute();

		Integer linhasModificadas = preparedStatement.getUpdateCount();

		System.out.println("Linhas alteradas: " + linhasModificadas);

		connection.close();
	}

}

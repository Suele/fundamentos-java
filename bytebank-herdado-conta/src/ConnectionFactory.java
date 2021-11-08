import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory é uma fabrica de conexão para BD, 
 * 
 **/

public class ConnectionFactory {

	public Connection criaConexao(String user, String password) throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				user, password);
	}

}

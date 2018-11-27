package conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static ConnectionFactory instance = null;

	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnetion() throws NamingException, SQLException {
		
		Context initialcontext = new javax.naming.InitialContext();
		Context context = (javax.naming.Context) initialcontext.lookup("java:");
		DataSource datasource = (javax.sql.DataSource) context.lookup("jboss/datasources/contratos");
		Connection connection = datasource.getConnection();
				
		return connection;
	}

}

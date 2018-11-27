package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.PoolException;

public class ConnectionPool {

	private static ConnectionPool instance = null;

	private List<Connection> connectionPool;
	private List<Connection> usedConnections;
	private int POOL_SIZE = 10;

	public static ConnectionPool getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	private ConnectionPool() throws SQLException {

		connectionPool = new ArrayList<>();
		usedConnections = new ArrayList<>();

		for (int i = 0; i < POOL_SIZE; i++) {
			connectionPool.add(createConnection());
		}

	}

	public Connection createConnection() throws SQLException {

		String url = "jdbc:mysql://127.0.0.1/contratos?useSSL=false";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);

	}

	public Connection getConnection() throws PoolException {
		if (connectionPool.size() < 1) {
			throw new PoolException("Pool vazio.");
		}
		Connection connection = connectionPool.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}

	public void releaseConnection(Connection connection) throws PoolException {
		connectionPool.add(connection);
		if (usedConnections.remove(connection) == false) {
			throw new PoolException("Esta conex�o n�o pertence ao Pool.");
		}
	}

}

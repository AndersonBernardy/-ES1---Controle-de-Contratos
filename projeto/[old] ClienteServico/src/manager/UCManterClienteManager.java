package manager;

import java.sql.Connection;
import java.sql.SQLException;

import col.COLCliente;
import conexao.ConnectionPool;
import model.Cliente;
import util.PoolException;
import util.validaException;

public class UCManterClienteManager implements UCManterClienteRMI {

	public void cadastrarCliente(Cliente cliente) {

		Connection connection = null;

		try {

			System.out.println("cadastrarCliente().");
			
			connection = ConnectionPool.getInstance().getConnection();
			connection.setAutoCommit(false);

			COLCliente col = new COLCliente();
			col.cadastrarCliente(connection, cliente);

			connection.commit();
			ConnectionPool.getInstance().releaseConnection(connection);

			System.out.println("Sucesso.");
			
		} catch (SQLException | PoolException e) {

			if (connection != null) {
				try {
					connection.rollback();
				} catch (Exception e2) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public Cliente obterClientePorCpf(String cpf) throws validaException {

		try {

			System.out.println("obterClientePorCpf().");
			
			Connection connection = ConnectionPool.getInstance().getConnection();

			COLCliente col = new COLCliente();
			Cliente cliente = col.obterClientePorCpf(connection, cpf);

			ConnectionPool.getInstance().releaseConnection(connection);

			System.out.println("Sucesso.");
			
			return cliente;

		} catch (SQLException | PoolException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} 

		return null;
	}

}

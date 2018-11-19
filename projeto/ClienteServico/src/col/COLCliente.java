package col;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DAOCliente;
import model.Cliente;
import pessoa.CPF;
import util.validaException;

public class COLCliente {

	public Cliente obterClientePorCpf(Connection connection, String cpfString) 
			throws SQLException, validaException {
		DAOCliente dao = new DAOCliente();
		CPF cpf = new CPF();
		cpf.setCpf(cpfString);
		Cliente cliente = dao.obterClientePorCpf(connection, cpf);
		return cliente;
	}

	public void cadastrarCliente(Connection connection, Cliente cliente) 
			throws SQLException {
		DAOCliente dao = new DAOCliente();
		dao.cadastrarCliente(connection, cliente);
	}

}

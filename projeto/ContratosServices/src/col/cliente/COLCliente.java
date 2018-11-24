package col.cliente;

import java.sql.Connection;

import cliente.Cliente;
import col.endereco.COLEndereco;
import dao.cliente.DAOCliente;

public class COLCliente {

	public Cliente selectCliente(Connection connection, int idCliente) {
		DAOCliente daoCliente = new DAOCliente();
		Cliente cliente = daoCliente.selectCliente(connection, idCliente);
		
		COLEndereco colEndereco = new COLEndereco();
		Endereco endereco = colEndereco.selectEndereco(connection, 
				cliente.getEnderecoEspecifico().getEndereco().getIdEndereco());
		
		return cliente;
	}

}

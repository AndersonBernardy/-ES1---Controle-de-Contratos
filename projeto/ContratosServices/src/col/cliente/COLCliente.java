package col.cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cliente.Cliente;
import col.endereco.COLEndereco;
import dao.cliente.DAOCliente;
import dao.cliente.DAOEmail;
import dao.cliente.DAOTelefone;
import endereco.Endereco;
import pessoa.Email;
import telefone.Telefone;
import util.PessoaException;

public class COLCliente {

	public Cliente consultarCliente(Connection connection, int idCliente) throws SQLException, PessoaException {
		DAOCliente daoCliente = new DAOCliente();
		Cliente cliente = daoCliente.selectCliente(connection, idCliente);
		
		DAOEmail daoEmail = new DAOEmail();
		List<Email> emailList = daoEmail.selectEmail(connection, idCliente);
		cliente.setEmailList(emailList);

		DAOTelefone daoTelefone = new DAOTelefone();
		List<Telefone> telefoneList = daoTelefone.selectTelefone(connection, idCliente);
		cliente.setTelefoneList(telefoneList);
		
		cliente.setQuantidadeContratos(daoCliente.getQuantidadeContratos(connection, idCliente));
		
		COLEndereco colEndereco = new COLEndereco();
		Endereco endereco = colEndereco.consultarEndereco(connection, 
				cliente.getEnderecoEspecifico().getEndereco().getIdEndereco());
		cliente.getEnderecoEspecifico().setEndereco(endereco);
		
		return cliente;
	}

}

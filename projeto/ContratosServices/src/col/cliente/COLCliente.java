package col.cliente;

import java.sql.Connection;
import java.sql.SQLException;

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
		Email[] emailList = daoEmail.selectEmail(connection, idCliente);
		cliente.getPessoa().setEmailList(emailList);

		DAOTelefone daoTelefone = new DAOTelefone();
		Telefone[] telefoneList = daoTelefone.selectTelefone(connection, idCliente);
		cliente.getPessoa().setTelefoneList(telefoneList);
		
		cliente.setQuantidadeContratos(daoCliente.getQuantidadeContratos(connection, idCliente));
		
		COLEndereco colEndereco = new COLEndereco();
		Endereco endereco = colEndereco.consultarEndereco(connection, 
				cliente.getPessoa().getEnderecoEspecifico().getEndereco().getIdEndereco());
		cliente.getPessoa().getEnderecoEspecifico().setEndereco(endereco);
		
		return cliente;
	}

}

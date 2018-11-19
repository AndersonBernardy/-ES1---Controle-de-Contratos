package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;
import pessoa.CPF;
import pessoa.Email;
import pessoa.EnderecoEspecifico;
import pessoa.RG;
import pessoa.Sexo;
import telefone.Telefone;
import util.validaException;

public class DAOCliente {

	public Cliente obterClientePorCpf(Connection connection, CPF cpf) 
			throws SQLException, validaException {

		String sql = "SELECT id_cliente, nome, cpf, rg, sexo, numero, complemento " 
			+ "FROM cliente, sexo "
			+ "WHERE cliente.id_sexo = sexo.id_sexo "
			+ "&& cpf = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cpf.getCpf());
		ResultSet result = statement.executeQuery();
		
		Cliente cliente = null;
		if(result.next()) {
			cliente = new Cliente();
			
			cliente.setNome(result.getString("nome"));
			
			CPF cpf2 = new CPF();
			cpf2.setCpf(result.getString("cpf"));
			cliente.setCpf(cpf2);
			
			RG rg = new RG();
			rg.setRg(result.getString("rg"));
			cliente.setRg(rg);
			
			Sexo sexo = new Sexo();
			sexo.setSexo(result.getString("sexo"));
			cliente.setSexo(sexo);
			
			EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
			enderecoEspecifico.setNumero(result.getInt("numero"));
			enderecoEspecifico.setComplemento("complemento");
			cliente.setEnderecoEspecifico(enderecoEspecifico);
			
			int idCliente = result.getInt("id_cliente");
		
			List<Telefone> telefoneList = new DAOTelefone()
					.obterTelefoneList(connection, idCliente);
			cliente.setTelefoneList(telefoneList);
			
			List<Email> emailList = new DAOEmail()
					.obterEmailList(connection, idCliente);
			cliente.setEmailList(emailList);
			
		}

		return cliente;
	}
	
	

	public void cadastrarCliente(Connection connection, Cliente cliente) 
			throws SQLException {

		String sql = "SELECT sexo, id_sexo FROM sexo WHERE sexo.sexo = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getSexo().getSexo());
		ResultSet result = statement.executeQuery();
		
		result.next();
		int id_sexo = result.getInt("id_sexo");

		sql = "INSERT INTO cliente (nome, cpf, rg, id_sexo, id_endereco, numero, complemento)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?);";

		statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf().getCpf());
		statement.setString(3, cliente.getRg().getRg());
		statement.setInt(4, id_sexo);
		statement.setInt(5, 1);
		statement.setInt(6, cliente.getEnderecoEspecifico().getNumero());
		statement.setString(7, cliente.getEnderecoEspecifico().getComplemento());
		statement.executeUpdate();

	}

}

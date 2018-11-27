package dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cliente.Cliente;
import endereco.Endereco;
import pessoa.CNPJ;
import pessoa.CPF;
import pessoa.EnderecoEspecifico;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import util.NegocioException;
import util.PessoaException;

public class DAOCliente {

	public Cliente selectCliente(Connection connection, int idCliente) throws SQLException, PessoaException {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			boolean isPessoaFisica = result.getBoolean("is_pessoa_fisica");
			cliente = new Cliente();
			Pessoa pessoa;
			
			
			if(isPessoaFisica) {
				pessoa = new PessoaFisica();
				cliente.setPessoa(pessoa);
				CPF cpf = new CPF();
				cpf.setCpf(result.getString("cpf"));
				((PessoaFisica) cliente.getPessoa()).setCpf(cpf);
			} else {
				pessoa = new PessoaJuridica();
				cliente.setPessoa(pessoa);
				CNPJ cnpj = new CNPJ();
				cnpj.setCnpj(result.getString("cnpj"));
				((PessoaJuridica) cliente.getPessoa()).setCnpj(cnpj);
			}

			cliente.getPessoa().setNome(result.getString("nome_cliente"));
			
			EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
			enderecoEspecifico.setComplemento(result.getString("complemento_endereco"));
			enderecoEspecifico.setNumero(result.getInt("numero_endereco"));
			
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(result.getInt("id_endereco"));
			enderecoEspecifico.setEndereco(endereco);
			
			cliente.getPessoa().setEnderecoEspecifico(enderecoEspecifico);
			
		}
		
		return cliente;
	}

	public int getQuantidadeContratos(Connection connection, int idCliente) throws SQLException {
		int quantidade = 0;
		
		String sql = "SELECT COUNT(id_contrato) FROM contrato WHERE id_cliente = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			quantidade = result.getInt(1);
		}
		
		return quantidade;
	}

	public int selectIdCliente(Connection connection, CPF cpf) throws SQLException, NegocioException {
		
		int idCliente = 0;
		String sql = "SELECT id_cliente FROM cliente WHERE cpf = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cpf.getCpf());
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			idCliente = result.getInt(1);
		} else {
			throw new NegocioException("Não há nenhum cliente com este cpf.");
		}
		
		return idCliente;
		
	}

	public int selectIdCliente(Connection connection, CNPJ cnpj) throws SQLException, NegocioException {
		
		int idCliente = 0;
		String sql = "SELECT id_cliente FROM cliente WHERE cnpj = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cnpj.getCnpj());
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			idCliente = result.getInt(1);
		} else {
			throw new NegocioException("Não há nenhum cliente com este cnpj.");
		}
		
		return idCliente;
		
	}


}

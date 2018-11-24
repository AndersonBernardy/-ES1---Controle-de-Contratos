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
			
			cliente.setNome(result.getString("nome_cliente"));
			
			if(isPessoaFisica) {
				CPF cpf = new CPF();
				cpf.setCpf(result.getString("cpf"));
				cliente.setCpf(cpf);
			} else {
				CNPJ cnpj = new CNPJ();
				cnpj.setCnpj(result.getString("cnpj"));
//				cliente.setCnpj(cnpj);
			}

			EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
			enderecoEspecifico.setComplemento(result.getString("complemento_endereco"));
			enderecoEspecifico.setNumero(result.getInt("numero_endereco"));
			
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(result.getInt("id_endereco"));
			enderecoEspecifico.setEndereco(endereco);
			
			cliente.setEnderecoEspecifico(enderecoEspecifico);
			
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


}

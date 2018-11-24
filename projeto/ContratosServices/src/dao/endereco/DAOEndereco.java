package dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Bairro;
import endereco.CEP;
import endereco.Cidade;
import endereco.Endereco;
import endereco.Rua;
import util.PessoaException;

public class DAOEndereco {

	public Endereco selectEndereco(Connection connection, int idEndereco) throws SQLException, PessoaException {
		Endereco endereco = null;
		String sql = "SELECT * FROM endereco WHERE id_endereco = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idEndereco);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			endereco = new Endereco();
			endereco.setIdEndereco(idEndereco);
			Rua rua = new Rua();
			rua.setIdRua(result.getInt("id_rua"));
			endereco.setRua(rua);
			Bairro bairro = new Bairro();
			bairro.setIdBairro(result.getInt("id_bairro"));
			endereco.setBairro(bairro);
			Cidade cidade = new Cidade();
			cidade.setIdCidade(result.getInt("id_cidade"));
			endereco.setCidade(cidade);
			CEP cep = new CEP();
			cep.setCep(result.getString("cep"));
			endereco.setCep(cep);
		}
		
		return endereco;
	}

}

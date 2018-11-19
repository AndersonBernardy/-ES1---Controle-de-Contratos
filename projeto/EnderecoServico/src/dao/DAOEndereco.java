package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Bairro;
import endereco.CEP;
import endereco.Cidade;
import endereco.Endereco;
import endereco.Estado;
import endereco.Rua;
import util.validaException;

public class DAOEndereco {

	public Endereco obterEnderecoPorCep(Connection connection, CEP cep) throws SQLException, validaException {

		String sql = "SELECT cep, cidade, estado, sigla, bairro, rua " 
				+ "FROM endereco, cidade, estado, bairro, rua "
				+ "WHERE endereco.id_cidade = cidade.id_cidade "
				+ "&& cidade.id_estado = estado.id_estado "
				+ "&& endereco.id_bairro = bairro.id_bairro "
				+ "&& endereco.id_rua = rua.id_rua "
				+ "&& cep = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cep.getCep());
		ResultSet result = statement.executeQuery();


		Endereco endereco = null;
		if(result.next()) {
			endereco = new Endereco();

			CEP cep2 = new CEP();
			cep2.setCep(result.getString("cep"));
			endereco.setCep(cep2);

			Estado estado = new Estado();
			estado.setEstado(result.getString("estado"));
			estado.setSigla(result.getString("sigla"));

			Cidade cidade = new Cidade();
			cidade.setCidade(result.getString("cidade"));
			cidade.setEstado(estado);
			endereco.setCidade(cidade);

			Bairro bairro = new Bairro();
			bairro.setBairro(result.getString("bairro"));
			endereco.setBairro(bairro);

			Rua rua = new Rua();
			rua.setRua(result.getString("rua"));
			endereco.setRua(rua);
		}

		return endereco;
	}

}

package col;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DAOEndereco;
import endereco.CEP;
import endereco.Endereco;
import util.validaException;

public class COLEndereco {

	public Endereco obterEnderecoPorCep(Connection connection, String cepString) throws SQLException, validaException {
		DAOEndereco dao = new DAOEndereco();
		CEP cep = new CEP();
		cep.setCep(cepString);
		Endereco endereco = dao.obterEnderecoPorCep(connection, cep);
		return endereco;
	}
	
}

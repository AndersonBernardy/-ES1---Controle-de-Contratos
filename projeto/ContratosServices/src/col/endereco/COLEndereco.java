package col.endereco;

import java.sql.Connection;
import java.sql.SQLException;

import dao.endereco.DAOBairro;
import dao.endereco.DAOCidade;
import dao.endereco.DAOEndereco;
import dao.endereco.DAOEstado;
import dao.endereco.DAORua;
import endereco.Bairro;
import endereco.Cidade;
import endereco.Endereco;
import endereco.Estado;
import endereco.Rua;
import util.PessoaException;

public class COLEndereco {

	public Endereco consultarEndereco(Connection connection, int idEndereco) throws SQLException, PessoaException {
		DAOEndereco daoEndereco = new DAOEndereco();
		Endereco endereco = daoEndereco.selectEndereco(connection, idEndereco);
		
		int idRua = endereco.getRua().getIdRua();
		DAORua daoRua = new DAORua();
		Rua rua = daoRua.selectRua(connection, idRua);
		endereco.setRua(rua);
		
		int idBairro = endereco.getBairro().getIdBairro();
		DAOBairro daoBairro = new DAOBairro();
		Bairro bairro = daoBairro.selectBairro(connection, idBairro);
		endereco.setBairro(bairro);
		
		int idCidade = endereco.getCidade().getIdCidade();
		DAOCidade daoCidade = new DAOCidade();
		Cidade cidade = daoCidade.selectCidade(connection, idCidade);
		
		int idEstado = cidade.getEstado().getIdEstado();
		DAOEstado daoEstado = new DAOEstado();
		Estado estado = daoEstado.selectEstado(connection, idEstado);
		cidade.setEstado(estado);
		endereco.setCidade(cidade);		
		
		return endereco;
	}

}

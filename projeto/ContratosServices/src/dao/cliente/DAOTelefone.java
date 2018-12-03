package dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import telefone.DDD;
import telefone.Telefone;
import util.PessoaException;

public class DAOTelefone {

	public List<Telefone> selectTelefone(Connection connection, int idCliente) throws PessoaException, SQLException {
		List<Telefone> telefoneList = new ArrayList<Telefone>();
		Telefone telefone = null;
		String sql = "SELECT * FROM telefone WHERE id_cliente = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();

		while(result.next()) {
			telefone = new Telefone();
			telefone.setNumeroTelefone(result.getString("numero_telefone"));
			DDD ddd = new DDD();
			ddd.setDdd(result.getString("ddd"));
			telefone.setDdd(ddd);
			telefoneList.add(telefone);
		}
		
		return telefoneList;
	}

}

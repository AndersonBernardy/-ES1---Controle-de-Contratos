package dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import telefone.DDD;
import telefone.Telefone;
import util.PessoaException;

public class DAOTelefone {

	public Telefone[] selectTelefone(Connection connection, int idCliente) throws PessoaException, SQLException {
		Telefone[] telefoneList = new Telefone[10];
		Telefone telefone = null;
		int i = 0;
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
			telefoneList[i++] = telefone;
		}
		
		return telefoneList;
	}

}

package dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Cidade;
import endereco.Estado;

public class DAOCidade {

	public Cidade selectCidade(Connection connection, int idCidade) throws SQLException {
		Cidade cidade = null;
		String sql = "SELECT * FROM cidade WHERE id_cidade = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCidade);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			cidade = new Cidade();
			cidade.setNomeCidade(result.getString("nome_cidade"));
			Estado estado = new Estado();
			estado.setIdEstado(result.getInt("id_estado"));
			cidade.setEstado(estado);
			cidade.setIdCidade(idCidade);
		}

		return cidade;
	}

}

package dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Estado;

public class DAOEstado {

	public Estado selectEstado(Connection connection, int idEstado) throws SQLException {
		Estado estado = null;
		String sql = "SELECT * FROM estado WHERE id_estado = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idEstado);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			estado = new Estado();
			estado.setNomeEstado(result.getString("nome_estado"));
			estado.setSigla(result.getString("sigla_estado"));
			estado.setIdEstado(idEstado);
		}
		
		return estado;
	}

}

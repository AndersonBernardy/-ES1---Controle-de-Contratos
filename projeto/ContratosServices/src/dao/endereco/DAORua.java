package dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Rua;

public class DAORua {

	public Rua selectRua(Connection connection, int idRua) throws SQLException {
		Rua rua = null;
		String sql = "SELECT * FROM rua WHERE id_rua = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idRua);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			rua = new Rua();
			rua.setNomeRua(result.getString("nome_rua"));
			rua.setIdRua(idRua);
		}
		
		return rua;
	}

}

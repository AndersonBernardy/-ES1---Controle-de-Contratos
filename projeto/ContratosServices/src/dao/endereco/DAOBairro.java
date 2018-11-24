package dao.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import endereco.Bairro;

public class DAOBairro {

	public Bairro selectBairro(Connection connection, int idBairro) throws SQLException {
		Bairro bairro = null;
		String sql = "SELECT * FROM bairro WHERE id_bairro = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idBairro);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			bairro = new Bairro();
			bairro.setNomeBairro(result.getString("nome_bairro"));
			bairro.setIdBairro(idBairro);
		}
		
		return bairro;
	}

}

package dao.contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contrato.TipoContrato;
import util.NegocioException;

public class DAOTipoContrato {

	public TipoContrato selectTipoContrato(Connection connection, int idTipoContrato) throws SQLException {
		TipoContrato tipoContrato = null;
		String sql = "SELECT * FROM tipo_contrato WHERE id_tipo_contrato = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idTipoContrato);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			tipoContrato = new TipoContrato();
			tipoContrato.setTipo(result.getString("nome_tipo_contrato"));
			tipoContrato.setIdTipoContrato(idTipoContrato);
		}
		
		return tipoContrato;
	}

	public int getidTipoContrato(Connection connection, String tipo) throws NegocioException, SQLException {
		int idTipoContrato = 0;
		String sql = "SELECT id_tipo_contrato FROM tipo_contrato WHERE nome_tipo_contrato = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, tipo);
		ResultSet result = statement.executeQuery();

		if(result.next()) {
			idTipoContrato = result.getInt(1);
		} else {
			throw new NegocioException("Não há nenhum tipo de contrato cadastrado com este nome.");
		}
		
		return idTipoContrato;
	}

}

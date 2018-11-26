package dao.contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cliente.Cliente;
import contrato.Contrato;
import contrato.TipoContrato;
import util.NegocioException;

public class DAOContrato {

	public Contrato selectContrato(Connection connection, int numero) throws SQLException, NegocioException {
		Contrato contrato = null;
		String sql = "SELECT * FROM contrato WHERE id_contrato = ?;";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, numero);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			contrato = new Contrato();
			contrato.setNumero(numero);

			TipoContrato tipoContrato = new TipoContrato();
			tipoContrato.setIdTipoContrato(result.getInt("id_tipo_contrato"));
			contrato.setTipoContrato(tipoContrato);

			Cliente cliente = new Cliente();
			cliente.setIdCliente(result.getInt("id_cliente"));
			contrato.setCliente(cliente);

			contrato.setDataEmissao(result.getDate("data_emissao"));
			contrato.setInicioValidade(result.getDate("inicio_validade"));
			contrato.setFimValidade(result.getDate("fim_validade"));
			contrato.setDescricao(result.getString("descricao"));
			contrato.setValor(result.getDouble("valor"));

		} else {
			throw new NegocioException("Não há contratos com este numero.");
		}

		return contrato;
	}

}

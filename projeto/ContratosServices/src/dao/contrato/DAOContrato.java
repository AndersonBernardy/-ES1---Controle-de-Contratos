package dao.contrato;

import java.sql.Connection;
import java.sql.Date;
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

		}

		return contrato;
	}

	public void InsertContrato(Connection connection, Contrato contrato) throws SQLException {

		String sql = "INSERT INTO contrato(id_contrato, data_emissao, inicio_validade, "
				+ "fim_validade, descricao, valor, id_tipo_contrato, id_cliente) " + "VALUES(?,?,?,?,?,?,?,?);";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, contrato.getNumero());
		statement.setDate(2, (Date) contrato.getDataEmissao());
		statement.setDate(3, (Date) contrato.getInicioValidade());
		statement.setDate(4, (Date) contrato.getFimValidade());
		statement.setString(5, contrato.getDescricao());
		statement.setDouble(6, contrato.getValor());
		statement.setInt(7, contrato.getTipoContrato().getIdTipoContrato());
		statement.setInt(8, contrato.getCliente().getIdCliente());

		statement.executeUpdate();
	}

	public boolean verificaQuantidadeContratosPeriodo(Connection connection, Contrato contrato) throws SQLException {
		int quantidade = 0;
		String sql = "SELECT COUNT(*) FROM contrato WHERE id_cliente = ?" + "&& inicio_validade >= ?"
				+ "&& inicio_validade <= ?" + "&& fim_validade >= ?" + "&& fim_validade <= ?;";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, contrato.getCliente().getIdCliente());
		statement.setDate(2, (Date) contrato.getInicioValidade());
		statement.setDate(3, (Date) contrato.getFimValidade());
		statement.setDate(4, (Date) contrato.getInicioValidade());
		statement.setDate(5, (Date) contrato.getFimValidade());

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			quantidade = result.getInt(1);
		} else {
			throw new SQLException("sla");
		}
		if (quantidade < 3) {
			return true;
		} else {
			return false;
		}
	}

}

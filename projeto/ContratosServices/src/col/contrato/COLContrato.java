package col.contrato;

import java.sql.Connection;
import java.sql.SQLException;

import cliente.Cliente;
import col.cliente.COLCliente;
import contrato.Contrato;
import contrato.TipoContrato;
import dao.contrato.DAOContrato;
import dao.contrato.DAOTipoContrato;
import util.NegocioException;
import util.PessoaException;

public class COLContrato {

	public Contrato consultarContrato(Connection connection, int numero)
			throws SQLException, PessoaException, NegocioException {
		DAOContrato daoContrato = new DAOContrato();
		Contrato contrato = daoContrato.selectContrato(connection, numero);

		DAOTipoContrato daoTipoContrato = new DAOTipoContrato();
		TipoContrato tipoContrato = daoTipoContrato.selectTipoContrato(connection,
				contrato.getTipoContrato().getIdTipoContrato());
		contrato.setTipoContrato(tipoContrato);

		COLCliente colCliente = new COLCliente();
		Cliente cliente = colCliente.consultarCliente(connection, contrato.getCliente().getIdCliente());
		contrato.setCliente(cliente);

		return contrato;
	}

}

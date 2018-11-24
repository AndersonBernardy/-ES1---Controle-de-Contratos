package col.contrato;

import java.sql.Connection;

import cliente.Cliente;
import col.cliente.COLCliente;
import contrato.Contrato;
import dao.contrato.DAOContrato;

public class COLContrato {

	public Contrato consultarContrato(Connection connection, int numero) {
		DAOContrato daoContrato = new DAOContrato();
		Contrato contrato = daoContrato.selectContrato(connection, numero);
		
		COLCliente colCliente = new COLCliente();
		Cliente cliente = colCliente.selectCliente(connection, contrato.getCliente().getIdCliente());
		contrato.setCliente(cliente);
		
		return contrato;
	}

}

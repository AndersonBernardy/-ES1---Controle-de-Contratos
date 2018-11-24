package manager;

import java.sql.Connection;

import col.contrato.COLContrato;
import conexao.ConnectionPool;
import contrato.Contrato;

public class UCManterContratosManager {

	public void cadastrarContrato(Contrato contrato) {
		
	}
	
	public Contrato consultarContratoPorNumero(int numero) throws Exception {
		
		Connection connection = null;
		Contrato contrato = null;
		
		try {
		
		connection = ConnectionPool.getInstance().getConnection();
		
		COLContrato colContrato = new COLContrato();
		contrato = colContrato.consultarContrato(connection, numero);
		
		ConnectionPool.getInstance().releaseConnection(connection);

		} catch (Exception e) {
			if(connection != null) {
				ConnectionPool.getInstance().releaseConnection(connection);
			}
		}
		
		return contrato;
	}
	
}

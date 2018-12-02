package manager;

import java.sql.Connection;

import col.contrato.COLContrato;
import connection.ConnectionFactory;
import contrato.Contrato;

public class UCManterContratosManager {

	public void cadastrarContrato(Contrato contrato) throws Exception {
		Connection connection = null;

		try {
		
		connection = ConnectionFactory.getInstance().getConnection();
		
		COLContrato colContrato = new COLContrato();
		colContrato.cadastrarContrato(connection, contrato);
		
		ConnectionFactory.getInstance().releaseConnection(connection);

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			if(connection != null) {
				ConnectionFactory.getInstance().releaseConnection(connection);
			}
		}
		
	}
	
	public Contrato consultarContratoPorNumero(int numero) throws Exception {
		Connection connection = null;
		Contrato contrato = null;
		
		try {
		
		connection = ConnectionFactory.getInstance().getConnection();
		
		COLContrato colContrato = new COLContrato();
		contrato = colContrato.consultarContrato(connection, numero);
		
		ConnectionFactory.getInstance().releaseConnection(connection);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				ConnectionFactory.getInstance().releaseConnection(connection);
			}
		}
		
		return contrato;
	}
	
}

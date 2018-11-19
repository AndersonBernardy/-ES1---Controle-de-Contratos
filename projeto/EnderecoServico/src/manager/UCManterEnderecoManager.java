package manager;

import java.sql.Connection;
import java.sql.SQLException;

import col.COLEndereco;
import conexao.ConnectionPool;
import endereco.Endereco;
import util.PoolException;
import util.validaException;

public class UCManterEnderecoManager implements UCManterEnderecoRMI {

	public Endereco obterEnderecoPorCep(String cep) {

		try {
			
			System.out.println("obterEnderecoPorCep().");
			
			Connection connection = ConnectionPool.getInstance().getConnection();
			
			COLEndereco col = new COLEndereco();
			Endereco endereco = col.obterEnderecoPorCep(connection, cep);
			
			ConnectionPool.getInstance().releaseConnection(connection);
			
			System.out.println("Sucesso.");
			
			return endereco;

		} catch (validaException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (PoolException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}  
		
		return null;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import telefone.DDD;
import telefone.DDI;
import telefone.Telefone;
import util.validaException;

public class DAOTelefone {

	public List<Telefone> obterTelefoneList(Connection connection, int idCliente) 
			throws SQLException, validaException {
		
		String sql = "SELECT ddi, ddd, telefone "
				+ "FROM telefone "
				+ "WHERE telefone.id_cliente = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();
		
		List<Telefone> telefoneList = new ArrayList<Telefone>();
		DDI ddi = null;
		DDD ddd = null;
		Telefone telefone = null;
		
		while(result.next()) {
			ddi = new DDI();
			ddd = new DDD();
			telefone = new Telefone();

			ddi.setDdi(result.getString("ddi"));
			telefone.setDdi(ddi);
			
			ddd.setDdd(result.getString("ddd"));
			telefone.setDdd(ddd);
			
			telefone.setTelefone(result.getString("telefone"));
			
			telefoneList.add(telefone);
		}
		
		return telefoneList;
	}
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pessoa.Email;
import util.validaException;

public class DAOEmail {

	public List<Email> obterEmailList(Connection connection, int idCliente) 
			throws SQLException, validaException{
		
		String sql = "SELECT email "
			+ "FROM email "
			+ "WHERE email.id_cliente = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();
				
		List<Email> emailList = new ArrayList<Email>();
		Email email = null;
		
		while(result.next()) {
			email = new Email();
			email.setEmail(result.getString("email"));
			
			emailList.add(email);
		}
		
		return emailList;
	}
	
}

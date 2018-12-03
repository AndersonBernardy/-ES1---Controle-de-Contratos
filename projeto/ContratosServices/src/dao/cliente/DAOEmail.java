package dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pessoa.Email;
import util.PessoaException;

public class DAOEmail {

	public List<Email> selectEmail(Connection connection, int idCliente) throws SQLException, PessoaException {
		List<Email> emailList = new ArrayList<Email>();
		Email email = null;
		String sql = "SELECT * FROM email WHERE id_cliente = ?;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet result = statement.executeQuery();

		while(result.next()) {
			email = new Email();
			email.setEmail(result.getString("email"));
			emailList.add(email);
		}
		
		return emailList;
	}

}

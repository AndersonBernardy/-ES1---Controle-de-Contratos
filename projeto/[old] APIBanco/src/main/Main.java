package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.ConnectionFactory;

public class Main {

	public static void main(String[] args) {

		try {

			Connection connection = ConnectionFactory.getInstance().getConnetion();
			
			String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, 1);
			ResultSet result = statement.executeQuery();
			int i = 0;
			while(result.next()) {
				System.out.println(result.getString(++i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

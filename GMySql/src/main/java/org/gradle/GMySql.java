package org.gradle;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GMySql {

	public static void main(String[] args) throws SQLException{
		
		System.out.println("GMySQL inicio");
		
		Connection connection=
				DriverManager.getConnection(
						"jdbc:mysql://localhost/dbprueba","root","sistemas");
		
		
		
		
		Statement selectStatement = connection.createStatement();
		ResultSet resultSet = selectStatement.executeQuery("select * from categoria");
		
		while (resultSet.next()){
			System.out.printf("id=%s nombre=%s \n", 
					resultSet.getObject("id"), resultSet.getObject("nombre"));
		}
		connection.close();
		
		System.out.println("Fin");
		
		
	}
}

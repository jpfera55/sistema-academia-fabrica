/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class Conexao {
      public Connection getConnection() {
	try {
	    //Class.forName("com.mysql.jdbc.Driver");  
	    DriverManager.registerDriver(new com.mysql.jdbc.Driver());  
	return
	(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sistemaClinica", "root", "admin");
      
	} catch (SQLException e) {
	throw new RuntimeException(e);
	}
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.Dao;

import br.com.Conexao.Conexao;
import br.com.Modelo.Cliente;
import br.com.Modelo.Usuariobean;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class usuarioDao {
    
    // a conexão com o banco de dados
    private Connection connection;

    public usuarioDao() {
      this.connection = new Conexao().getConnection();
    }
    
    public void adiciona(Usuariobean usuario) {
	    String sql = "insert into usuario " +
	            "(usuario,senha,autentica)" +
	            " values (?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,usuario.getUsuario());
	        stmt.setString(2,usuario.getSenha());
	        stmt.setInt(3,usuario.getAutentica());
          

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
    
     public List<Usuariobean> getLista() {
	try {	
	List<Usuariobean> usuarios = new ArrayList<Usuariobean>();
	PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from usuario");
	ResultSet rs= stmt.executeQuery();
	
		while(rs.next()){
		    Usuariobean usuario = new Usuariobean();
		    usuario.setId(rs.getLong("id"));
		   usuario.setUsuario(rs.getString("usuario"));
		   usuario.setSenha(rs.getString("senha"));
		   usuario.setAutentica(rs.getInt("autentica"));
                  
		    usuarios.add(usuario);
	        }
		rs.close();
		stmt.close();
		//connection.close();
	     return usuarios;
	 } catch (SQLException e) {
	         throw new RuntimeException(e);
	  }
    }
     
    public void alterar(Usuariobean usuario){
    
       String sql = "update usuario set usuario=? , senha=? , autentica=?  where id=?";
        try{
           java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, usuario.getUsuario());
           stmt.setString(2, usuario.getSenha());
           stmt.setInt(3, usuario.getAutentica());         
           stmt.setLong(4, usuario.getId());
           
           stmt.execute();
           stmt.close();
        }catch(SQLException e){
          throw new RuntimeException(e);
        }
    
    }
    
}

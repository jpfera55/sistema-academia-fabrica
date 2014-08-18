/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.Dao;

import br.com.Conexao.Conexao;
import br.com.Modelo.Cliente;
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
public class clienteDao {
    
        
 // a conexão com o banco de dados
    private Connection connection;

    public clienteDao() {
      this.connection = new Conexao().getConnection();
    }
    
    public void adiciona(Cliente cliente) {
	    String sql = "insert into cliente " +
	            "(nome,email,cpf,rg,situacao)" +
	            " values (?,?,?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,cliente.getNome());
	        stmt.setString(2,cliente.getEmail());
	        stmt.setString(3,cliente.getCpf());
                stmt.setString(4,cliente.getRg());
                stmt.setString(5,cliente.getSituacao());
	     

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
    
     public List<Cliente> getLista() {
	try {	
	List<Cliente> clientes = new ArrayList<Cliente>();
	PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from cliente");
	ResultSet rs= stmt.executeQuery();
	
		while(rs.next()){
		    Cliente cliente = new Cliente();
		    cliente.setId(rs.getLong("id"));
		    cliente.setNome(rs.getString("nome"));
		    cliente.setEmail(rs.getString("email"));
		    cliente.setCpf(rs.getString("cpf"));
                    cliente.setRg(rs.getString("rg"));
		    cliente.setSituacao(rs.getString("situacao"));
		    clientes.add(cliente);
	        }
		rs.close();
		stmt.close();
		//connection.close();
	     return clientes;
	 } catch (SQLException e) {
	         throw new RuntimeException(e);
	  }
    }
     
    public void alterar(Cliente cliente){
    
       String sql = "update cliente set nome=? , email=? , cpf=? , rg=? , situacao=? where id=?";
        try{
           java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, cliente.getNome());
           stmt.setString(2, cliente.getEmail());
           stmt.setString(3, cliente.getCpf());
           stmt.setString(4, cliente.getRg());
           stmt.setString(5, cliente.getSituacao());
           stmt.setLong(6, cliente.getId());
           
           stmt.execute();
           stmt.close();
        }catch(SQLException e){
          throw new RuntimeException(e);
        }
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import br.com.Conexao.Conexao;
import br.com.Modelo.Cliente;
import br.com.Modelo.Planobean;
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
public class planoDao {

    private Connection connection;

    public planoDao() {

        this.connection = new Conexao().getConnection();

    }

    public void adiciona(Planobean plano) {
        String sql = "insert into plano "
                + "(nome,valor,quantidadeMeses)"
                + " values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

	        // seta os valores
            stmt.setString(1, plano.getNome());
            stmt.setDouble(2, plano.getValor());
            stmt.setInt(3, plano.getQuantidadeMeses());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Planobean> getLista() {
        try {
            List<Planobean> planos = new ArrayList<Planobean>();
            PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from plano");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Planobean plano = new Planobean();
                plano.setId(rs.getLong("id"));
                plano.setNome(rs.getString("nome"));
                plano.setValor(rs.getDouble("valor"));
                plano.setQuantidadeMeses(rs.getInt("quantidadeMeses"));

                planos.add(plano);
            }
            rs.close();
            stmt.close();
            //connection.close();
            return planos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Planobean plano) {

        String sql = "update plano set nome=? , valor=? , quantidadeMeses=? where id=?";
        try {
            java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, plano.getNome());
            stmt.setDouble(2, plano.getValor());
            stmt.setInt(3, plano.getQuantidadeMeses());          
            stmt.setLong(4, plano.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

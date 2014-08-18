/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.Main;

import br.com.Conexao.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class app {
    public static void main(String args[]){
    
        Connection con = new Conexao().getConnection();
        
        JOptionPane.showMessageDialog(null,"connectoou");
       
    }
}

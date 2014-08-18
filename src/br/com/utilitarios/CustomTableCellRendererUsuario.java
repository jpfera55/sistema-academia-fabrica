/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utilitarios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author marcos
 */
public class CustomTableCellRendererUsuario  extends DefaultTableCellRenderer {
      public CustomTableCellRendererUsuario() {  
         
         
    }  
      
      @Override
       public Component getTableCellRendererComponent (JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
			Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
			if (!isSelected) {
				 cell.setBackground(getBackground());
                                String quant= (String) table.getValueAt(row, 3);  
                                if("Administrador".equals(quant)) {  
                                   setBackground(new Color(75,140,212));           
                            
                               }else {  
                                      setBackground(new Color(254,254,217));               
                              }  
                                              
                               
			} 	
                        
			
			return cell;
		}
}

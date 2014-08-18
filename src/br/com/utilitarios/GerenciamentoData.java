/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.utilitarios;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class GerenciamentoData {

    public GerenciamentoData() {
    }

    public String getEditeData(int quantidadeDia, int quantidadeMeses, int quantidadeAnos) {
        String result = null;
        int dia;
        int mes;
        int ano;
        int aux;
        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        ano = c.get(Calendar.YEAR);

        if ((mes + quantidadeMeses) > 12) {

            ano = ano + 1;
            aux = (mes + quantidadeMeses) - 12;
            c.set(ano, aux, dia);
            Date data = c.getTime();
            DateFormat formataData = DateFormat.getDateInstance();
            result = dia + "/" + aux + "/" + ano;
            return formataData.format(data);
        } else {

            mes = mes + quantidadeMeses;
            c.set(ano, mes, dia);
            Date data = c.getTime();
            DateFormat formataData = DateFormat.getDateInstance();
            result = dia + "/" + mes + "/" + ano;
            return formataData.format(data);
        }

        //return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.Modelo;

import sun.security.util.Password;

/**
 *
 * @author marcos
 */
public class Usuariobean {
    
    private long id;
    private String usuario;
    private String senha;
    private int autentica;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAutentica() {
        return autentica;
    }

    public void setAutentica(int autentica) {
        this.autentica = autentica;
    }
    
    
    
}

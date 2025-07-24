/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.models;

/**
 *
 * @author thamFernandes
 */
public class Medico {
    private String crm;
    private String nome;
    private String especialidade;
    private String contato;
    private String senha;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Medico() {
    }

    public Medico(String crm, String nome, String especialidade, String contato, String senha) {
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.contato = contato;
        this.senha = senha;
    }
    
    
    
}

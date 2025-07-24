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
public class Paciente {
    private String cpf;
    private String nome;
    private String endereco;
    private String contato;
    private String planoSaude;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Paciente() {
    }

    public Paciente(String cpf, String nome, String endereco, String contato, String planoSaude) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.planoSaude = planoSaude;
    }
    
   
}

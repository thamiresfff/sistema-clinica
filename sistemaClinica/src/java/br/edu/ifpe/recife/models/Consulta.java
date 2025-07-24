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
public class Consulta {
    private int codigo;
    private String dataHora;
    private String dataHoraVolta;
    private String observacao;
    private Paciente paciente;
    private Medico medico;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataHoraVolta() {
        return dataHoraVolta;
    }

    public void setDataHoraVolta(String dataHoraVolta) {
        this.dataHoraVolta = dataHoraVolta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    } 

    public Consulta() {
    }

    public Consulta(int codigo, String dataHora, String dataHoraVolta, String observacao, Paciente paciente, Medico medico) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.dataHoraVolta = dataHoraVolta;
        this.observacao = observacao;
        this.paciente = paciente;
        this.medico = medico;
    }
    
    
}

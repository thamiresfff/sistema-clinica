/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.repositories;

import br.edu.ifpe.recife.models.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamFernandes
 */
public class PacienteRepositorio {
    private static List<Paciente> pacientes;

    static {
        PacienteRepositorio.pacientes = new ArrayList();
    }

    public static void criar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static Paciente ler(String cpf) {
        for(Paciente p : pacientes) {
            if(cpf.equals(p.getCpf())) {
                return p;
            }
        }
        return null;
    }

    public static void deletar(Paciente p) {
        pacientes.remove(p);
    }

    public static List<Paciente> lerTudo() {
        return pacientes;
    }

    public static void atualizar(Paciente p){
        for(int i = 0; i< pacientes.size(); i++){
            if(pacientes.get(i).getCpf().equals(p.getCpf())){
                Paciente pAux = pacientes.get(i);
                pAux.setContato(p.getContato());
                pAux.setCpf(p.getCpf());
                pAux.setEndereco(p.getEndereco());
                pAux.setNome(p.getNome());
                pAux.setPlanoSaude(p.getPlanoSaude());
                return;
            }
        }
    }
}

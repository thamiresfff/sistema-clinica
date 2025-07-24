/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.repositories;

import br.edu.ifpe.recife.models.Medico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamFernandes
 */
public class MedicoRepositorio {
    private static List<Medico> medicos;

    static {
        MedicoRepositorio.medicos = new ArrayList();
    }

    public static void criar(Medico paciente) {
        medicos.add(paciente);
    }

    public static Medico ler(String crm) {
        for(Medico p : medicos) {
            if(crm.equals(p.getCrm())) {
                return p;
            }
        }
        return null;
    }

    public static void deletar(Medico p) {
        medicos.remove(p);
    }

    public static List<Medico> lerTudo() {
        return medicos;
    }

    public static void atualizar(Medico p){
        for(int i = 0; i< medicos.size(); i++){
            if(medicos.get(i).getCrm().equals(p.getCrm())){
                Medico pAux = medicos.get(i);
                pAux.setContato(p.getContato());
                pAux.setCrm(p.getCrm());
                pAux.setEspecialidade(p.getEspecialidade());
                pAux.setNome(p.getNome());
                return;
            }
        }
    }
}

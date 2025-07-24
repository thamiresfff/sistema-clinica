/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.repositories;

import br.edu.ifpe.recife.models.Medicamento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamFernandes
 */
public class MedicamentoRepositorio {
    private static List<Medicamento> medicamentos;

    static {
        MedicamentoRepositorio.medicamentos = new ArrayList();
    }

    public static void criar(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public static Medicamento ler(int codigo) {
        for(Medicamento m : medicamentos) {
            if(codigo == m.getCodigo()) {
                return m;
            }
        }
        return null;
    }

    public static void deletar(Medicamento m) {
        medicamentos.remove(m);
    }

    public static List<Medicamento> lerTudo() {
        return medicamentos;
    }

    public static void atualizar(Medicamento m){
        for(int i = 0; i< medicamentos.size(); i++){
            if(medicamentos.get(i).getCodigo() == (m.getCodigo())){
                Medicamento pAux = medicamentos.get(i);
                pAux.setCodigo(m.getCodigo());
                pAux.setDescricao(m.getDescricao());
                pAux.setDosagem(m.getDosagem());
                pAux.setNome(m.getNome());
                pAux.setObservacao(m.getObservacao());
                pAux.setTipoDosagem(m.getTipoDosagem());
                return;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.repositories;

import br.edu.ifpe.recife.models.IndicadorExame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thamFernandes
 */
public class IndicadorExameRepositorio {
    private static List<IndicadorExame> indicadores;

    static {
        IndicadorExameRepositorio.indicadores = new ArrayList();
    }

    public static void criar(IndicadorExame indicador) {
        indicadores.add(indicador);
    }

    public static IndicadorExame ler(int codigo) {
        for(IndicadorExame p : indicadores) {
            if(codigo == p.getCodigo()) {
                return p;
            }
        }
        return null;
    }

    public static void deletar(IndicadorExame p) {
        indicadores.remove(p);
    }

    public static List<IndicadorExame> lerTudo() {
        return indicadores;
    }

    public static void atualizar(IndicadorExame p){
        for(int i = 0; i< indicadores.size(); i++){
            if(indicadores.get(i).getCodigo() == (p.getCodigo())){
                IndicadorExame pAux = indicadores.get(i);
                pAux.setCodigo(p.getCodigo());
                pAux.setDescricao(p.getDescricao());
                pAux.setIndicador(p.getIndicador());
                pAux.setMaxValorReferencia(p.getMaxValorReferencia());
                pAux.setMinValorReferencia(p.getMinValorReferencia());
                return;
            }
        }
    }
}

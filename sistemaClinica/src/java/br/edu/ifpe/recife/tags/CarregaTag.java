/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.tags;

import br.edu.ifpe.recife.repositories.IndicadorExameRepositorio;
import br.edu.ifpe.recife.repositories.MedicamentoRepositorio;
import br.edu.ifpe.recife.repositories.MedicoRepositorio;
import br.edu.ifpe.recife.repositories.PacienteRepositorio;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author thamFernandes
 */
public class CarregaTag extends SimpleTagSupport {
    private String entidade;
    private String var;
    private String escopo;
    private String id; 

    // Setters chamados automaticamente via atributos da tag
    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        Object resultado;

        // Carregamento da entidade
        switch (entidade.toLowerCase()) {
            case "medico":
                resultado = (id == null) ? MedicoRepositorio.lerTudo() : MedicoRepositorio.ler(id);
                break;
            case "paciente":
                resultado = (id == null) ? PacienteRepositorio.lerTudo() : PacienteRepositorio.ler(id);
                break;
            case "medicamento":
                resultado = (id == null) ? MedicamentoRepositorio.lerTudo() : MedicamentoRepositorio.ler(Integer.getInteger(id));
                break;
            case "indicador_exame":
                resultado = (id == null) ? IndicadorExameRepositorio.lerTudo() : IndicadorExameRepositorio.ler(Integer.getInteger(id));
                break;
            default:
                throw new JspException("Entidade desconhecida: " + entidade);
        }

        // Determina escopo
        int escopoCode;
        switch (escopo.toLowerCase()) {
            case "pagina":
                escopoCode = PageContext.PAGE_SCOPE;
                break;
            case "requisicao":
                escopoCode = PageContext.REQUEST_SCOPE;
                break;
            case "sessao":
                escopoCode = PageContext.SESSION_SCOPE;
                break;
            case "aplicacao":
                escopoCode = PageContext.APPLICATION_SCOPE;
                break;
            default:
                throw new JspException("Escopo inválido: " + escopo);
        }

        // Armazena no escopo escolhido
        PageContext context = (PageContext) getJspContext();
        context.setAttribute(var, resultado, escopoCode);
    }
}

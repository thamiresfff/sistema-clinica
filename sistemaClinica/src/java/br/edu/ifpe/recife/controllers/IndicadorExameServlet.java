/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.models.IndicadorExame;
import br.edu.ifpe.recife.repositories.IndicadorExameRepositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thamFernandes
 */
@WebServlet(name = "IndicadorExameServlet", urlPatterns = {"/IndicadorExameServlet"})
public class IndicadorExameServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<IndicadorExame> indicadores = IndicadorExameRepositorio.lerTudo();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet IndicadorExameServlet</title>");            
                out.println("<link rel='stylesheet' href='/sistemaClinica/estilo/style.css'/>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Indicador Exame</h1>");
                out.println("<a href='/sistemaClinica/cadastrarMedico.jsp'>Voltar</a>");
                out.println("<ul>");
                for(IndicadorExame ie : indicadores) {
                    out.println("<li style='margin-bottom: 10px; padding: 5px; border: 1px solid black; border-radius: 5px;'>");
                        out.println("<p> Indicador: "+ie.getIndicador()+"</p>");
                        out.println("<p> Descricao: "+ie.getDescricao()+"</p>");
                    out.println("</li>");
                }
                out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String indicador = request.getParameter("indicador");
        String descricao = request.getParameter("descricao");
        Double minValorReferencia = Double.parseDouble(request.getParameter("minValorReferencia").replace(",", "."));
        Double maxValorReferencia = Double.parseDouble(request.getParameter("maxValorReferencia").replace(",", "."));


        IndicadorExame i = new IndicadorExame(
                codigo,
                indicador,
                descricao,
                minValorReferencia,
                maxValorReferencia
        );
        
        IndicadorExameRepositorio.criar(i);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet IndicadorExameServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Indicador de Exame criado com sucesso!</h1>");
            out.println("<a href='/sistemaClinica/IndicadorExameServlet'>Lista de Indicadores</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

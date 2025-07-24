/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.models.Medicamento;
import br.edu.ifpe.recife.repositories.MedicamentoRepositorio;
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
@WebServlet(name = "MedicamentoServlet", urlPatterns = {"/MedicamentoServlet"})
public class MedicamentoServlet extends HttpServlet {


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
        
        List<Medicamento> medicamentos = MedicamentoRepositorio.lerTudo();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet MedicamentoServlet</title>");            
                out.println("<link rel='stylesheet' href='/Clinica/estilos/style.css'/>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Medicamentos</h1>");
                out.println("<a href='/Clinica/cadastrar-medicamento.html'>Voltar</a>");
                out.println("<ul>");
                for(Medicamento m : medicamentos) {
                    out.println("<li style='margin-bottom: 10px; padding: 5px; border: 1px solid black; border-radius: 5px;'>");
                        out.println("<p> Codigo: "+m.getCodigo()+"</p>");
                        out.println("<p> Nome: "+m.getNome()+"</p>");
                        out.println("<p> Observacao: "+m.getObservacao()+"</p>");
                        out.println("<p> Dosagem: "+m.getDosagem()+"</p>");
                        out.println("<p> Tipo dosagem: "+m.getTipoDosagem()+"</p>");
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
        String nome = request.getParameter("nome");
        int dosagem = Integer.parseInt(request.getParameter("dosagem"));
        String tipoDosagem = request.getParameter("tipoDosagem");
        String descricao = request.getParameter("descricao");
        String observacao = request.getParameter("observacao");
        Medicamento m = new Medicamento(
                codigo,
                nome,
                dosagem,
                tipoDosagem,
                descricao,
                observacao
        );
        MedicamentoRepositorio.criar(m);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet MedicamentoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Medicamento criado com sucesso!</h1>");
            out.println("<a href='/sistemaClinica/MedicamentoServlet'>Lista de medicamentos</h1>");
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

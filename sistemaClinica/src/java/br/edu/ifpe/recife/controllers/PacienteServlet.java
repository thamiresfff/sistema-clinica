/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.models.Paciente;
import br.edu.ifpe.recife.repositories.PacienteRepositorio;
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
@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {


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
        
        List<Paciente> pacientes = PacienteRepositorio.lerTudo();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet PacienteServlet</title>");            
                out.println("<link rel='stylesheet' href='/sistemaClinica/estilo/style.css'/>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Pacientes</h1>");
                out.println("<a href='/sistemaClinica/paciente.html'>Voltar</a>");
                out.println("<ul>");
                for(Paciente m : pacientes) {
                    out.println("<li style='margin-bottom: 10px; padding: 5px; border: 1px solid black; border-radius: 5px;'>");
                        out.println("<p> CPF: "+m.getCpf()+"</p>");
                        out.println("<p> Nome: "+m.getNome()+"</p>");
                        out.println("<p> Endereco: "+m.getEndereco()+"</p>");
                        out.println("<p> Contato: "+m.getContato()+"</p>");
                        out.println("<p> PlanoSaude: "+m.getPlanoSaude()+"</p>");
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
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String contato = request.getParameter("contato");
        String planoSaude = request.getParameter("observacao");
        Paciente p = new Paciente(
                cpf,
                nome,
                endereco,
                contato,
                planoSaude
        );
        
        PacienteRepositorio.criar(p);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet PacienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Paciente criado com sucesso!</h1>");
            out.println("<a href='/sistemaClinica/PacienteServlet'>Lista de Pacientes</h1>");
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

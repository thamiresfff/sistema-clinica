/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.models.Medico;
import br.edu.ifpe.recife.repositories.MedicoRepositorio;
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
@WebServlet(name = "MedicoServlet", urlPatterns = {"/MedicoServlet"})
public class MedicoServlet extends HttpServlet {


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
        List<Medico> medicos = MedicoRepositorio.lerTudo();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet MedicoServlet</title>");            
                out.println("<link rel='stylesheet' href='/sistemaClinica/estilo/style.css'/>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Medicos</h1>");
                out.println("<a href='/sistemaClinica/cadastrarMedico.jsp'>Voltar</a>");
                out.println("<ul>");
                for(Medico m : medicos) {
                    out.println("<li style='margin-bottom: 10px; padding: 5px; border: 1px solid black; border-radius: 5px;'>");
                        out.println("<p> CRM: "+m.getCrm()+"</p>");
                        out.println("<p> Nome: "+m.getNome()+"</p>");
                        out.println("<p> Especialidade: "+m.getEspecialidade()+"</p>");
                        out.println("<p> Contato: "+m.getContato()+"</p>");
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

        String op = request.getParameter("op");

        if ("update".equals(op)) {
            String crm = request.getParameter("crm");
            String nome = request.getParameter("nome");
            String especialidade = request.getParameter("especialidade");
            String contato = request.getParameter("contato");

            String senhaAtual = request.getParameter("senhaAtual");
            String novaSenha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmarSenha");

            // Buscar médico pelo CRM
            Medico medico = MedicoRepositorio.ler(crm);

            if (medico == null) {
                request.getRequestDispatcher("/sistemaClinica/profile.jsp").forward(request, response);
                return;
            }

            medico.setNome(nome);
            medico.setEspecialidade(especialidade);
            medico.setContato(contato);

            if (novaSenha != null && !novaSenha.isEmpty()) {
                if (!senhaAtual.equals(medico.getSenha())) {
                    request.setAttribute("erroSenha", "Senha atual incorreta.");
                    request.getRequestDispatcher("/sistemaClinica/profile.jsp").forward(request, response);
                    return;
                }

                if (!novaSenha.equals(confirmarSenha)) {
                    request.setAttribute("erroSenha", "A nova senha e a confirmação não coincidem.");
                    request.getRequestDispatcher("/sistemaClinica/profile.jsp").forward(request, response);
                    return;
                }

                medico.setSenha(novaSenha);
            }

            MedicoRepositorio.atualizar(medico);
            response.sendRedirect("/sistemaClinica/profile.jsp");
            return;
        }

        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String contato = request.getParameter("contato");
        String senha = request.getParameter("senha");

        Medico m = new Medico();
        m.setCrm(crm);
        m.setNome(nome);
        m.setEspecialidade(especialidade);
        m.setContato(contato);
        m.setSenha(senha);

        MedicoRepositorio.criar(m);
        response.sendRedirect("login.jsp");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.models.Medico;
import br.edu.ifpe.recife.repositories.MedicoRepositorio;
import java.io.IOException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


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
        String crm = request.getParameter("crm");
        String password = request.getParameter("password");
        String op = request.getParameter("op");
        
        if(op != null && op.equals("logout")) {
            request.getSession().setAttribute("medico", null);
            response.sendRedirect("login.jsp");
            return;
        }
        
        List<Medico> medicos = MedicoRepositorio.lerTudo();
        
        for(Medico m : medicos) {
            if(crm.equals(m.getCrm()) && password.equals(m.getSenha())) {
                response.sendRedirect("/sistemaClinica/index.jsp");
                request.getSession().setAttribute("medico", m);
                return;
            }
        }
        
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

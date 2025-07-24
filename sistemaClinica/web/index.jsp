<%-- 
    Document   : index
    Created on : Jun 15, 2025, 9:52:27 PM
    Author     : anale
--%>

<%@page import="br.edu.ifpe.recife.models.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Medico medico = (Medico) session.getAttribute("medico");
    if(medico == null) {
        response.sendRedirect("login.jsp?redirected=true");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Clínica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estilo/style.css">

    </head>
    <body>
        <h1>Bem-vindo ao Sistema da Clínica</h1>
        <header>
            <p>
                Bem-vindo <%= medico.getNome() %>
            </p>
            <form action="/sistemaClinica/Login" method="POST">
                <input type="text" name="op" value="logout" hidden />
                <button type="submit">
                    SAIR
                </button>
            </form>
        </header>
        <div class="menu">
            <a href="/sistemaClinica/profile.jsp">Perfil</a>
            <a href="paciente.html">Pacientes</a>
            <a href="cadastrarMedico.jsp">Médicos</a>
            <a href="medicamento.html">Medicamentos</a>
            <a href="indicadorExame.html">Indicadores de Exame</a>
        </div>
    </body>
</html>
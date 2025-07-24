<%-- 
    Document   : profile
    Created on : Jun 15, 2025, 9:51:56 PM
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

    String erroSenha = (String) request.getAttribute("erroSenha");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil do Médico</title>
        <link rel="stylesheet" href="estilo/style.css">
    </head>
    <body>
        <% if (erroSenha != null) { %>
            <script>
                alert("<%= erroSenha.replace("\"", "\\\"") %>");
            </script>
        <% } %>

        <a href='/sistemaClinica/index.jsp'>Voltar</a>

        <form action="/sistemaClinica/MedicoServlet?op=update" method="POST">
            <label for="crm">CRM:</label>
            <input type="text" id="crm" name="crm" value="<%= medico.getCrm() %>" readonly>

            <!-- Nome -->
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= medico.getNome() %>">

            <!-- Especialidade -->
            <label for="especialidade">Especialidade:</label>
            <input type="text" id="especialidade" name="especialidade" value="<%= medico.getEspecialidade() %>">

            <!-- Contato -->
            <label for="contato">Contato:</label>
            <input type="text" id="contato" name="contato" value="<%= medico.getContato() %>">

            <!-- Senha Atual -->
            <label for="senhaAtual">Senha Atual:</label>
            <input type="password" id="senhaAtual" name="senhaAtual">

            <!-- Nova Senha -->
            <label for="senha">Nova Senha:</label>
            <input type="password" id="senha" name="senha">

            <!-- Confirmar Nova Senha -->
            <label for="confirmarSenha">Confirmar Nova Senha:</label>
            <input type="password" id="confirmarSenha" name="confirmarSenha">

            <button type="submit">ENVIAR</button>
        </form>
    </body>
</html>

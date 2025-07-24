<%-- 
    Document   : login
    Created on : Jun 15, 2025, 9:51:00 PM
    Author     : anale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String redirected = request.getParameter("redirected");
    boolean foiRedirecionado = "true".equals(redirected);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Sistema Clínica</title>
        <link rel="stylesheet" href="estilo/style.css">
    </head>
    <body>
        <main>
            <h2>Bem-vindo ao Sistema da Clínica</h2>
            <form action="/sistemaClinica/Login" method="POST">
                <label>
                    CRM: <input type="text" name="crm" />
                </label>
                <label>
                    Senha: <input type="password" name="password" />
                </label>
                <button type="submit">
                    LOGIN
                </button>
            </form>
            <a href="/sistemaClinica/cadastrarMedico.jsp">
                Cadastrar medico
            </a>
        </main>
    </body>
    <script>
        <% if (foiRedirecionado) { %>
            alert("Cliente não cadastrado!");
        <% } %>
        console.log(<%= foiRedirecionado %>);
    </script>
</html>

<%-- 
    Document   : cadastrarMedico
    Created on : Jun 15, 2025, 10:01:06 PM
    Author     : anale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Medico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estilo/style.css">
    </head>
    <body>
        <main>
        <h1>Cadastro de Medico</h1>
        <a href='/sistemaClinica/login.jsp'>Voltar</a>
        
        <!--Formulário de Cadastro-->
        <form action="MedicoServlet" method="post">
            <!--CRM-->
            <label for="crm">CRM:</label>
            <input type="text" id="crm" name="crm" required>

            <!--NOME-->
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>

            <!--ESPECIALIDADE-->
            <label for="especialidade">Especialidade:</label>
            <input type="text" id="especialidade" name="especialidade" required>

            <!--CONTATO-->
            <label for="contato">Contato:</label>
            <input type="text" id="contato" name="contato" required>
            
            <label for="senha">Senha:</label>
            <input type="text" id="senha" name="senha" required>
            
            
            <button type="submit">
                ENVIAR
            </button>
        </form>
        </main>
        <!--Lista dos Medicos-->
        <div class="listagem">
            <form action="MedicoServlet" method="get">
                <button type="submit">Listar Medicos</button>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : medicos
    Created on : 28/06/2025, 23:12:00
    Author     : anale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicos</title>
    </head>
    <body>
        <h2>
            Medicos
        </h2>
        <ifpe:carrega entidade="medico" var="medicos" escopo="session" />
    </body>
</html>

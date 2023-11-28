<%-- 
    Document   : IncioPrueba
    Created on : 28/11/2023, 11:26:49 AM
    Author     : HP
--%>

<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <%
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        %>
        <p>Nombre: <%=usuario.getNombres()%></p>
        <p>Avatar: <%=usuario.getAvatar()%></p>

    </body>
</html>

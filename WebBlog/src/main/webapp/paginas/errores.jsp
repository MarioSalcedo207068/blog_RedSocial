<%-- 
    Document   : errores
    Created on : 5 dic 2023, 11:44:34
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Errores</title>
    </head>
    <body>
    <center>
        <table width="500px">
            <tr bgcolor="lightgray">
                <th>ERROR de LogIn</th>
            </tr>
        <%
            String msg=(String) request.getAttribute("msg");
            out.println("<tr align='center'>");
            out.println("<td>"+msg+"</td");
            out.println("</tr>");
        %>
        </table>
        <br/>
        <<a href="Login.jsp">Volver a LogIn</a>
    </center>
        
        
        
    </body>
</html>

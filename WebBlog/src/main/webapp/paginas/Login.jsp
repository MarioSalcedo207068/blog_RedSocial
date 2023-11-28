<%-- 
    Document   : Login
    Created on : 27/11/2023, 08:37:34 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio de Sesión</title>
        <link href="../estilos/Login.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <main class="formulario">
            <h1>Inicio de Sesión</h1>

            <form method="post">
                <div class="username">
                    <input type="text" required placeholder="Nombre de Usuario">

                </div>
                <div class="contraseña">
                    <input type="password" required placeholder="Contraseña">
                </div>
                <input type="submit" value="Iniciar">
                <div class="registrarse">
                    ¿No tienes cuenta? <a href="Register.jsp">Regístrate</a>
                </div>
            </form>
        </main>
    </body>

</html>
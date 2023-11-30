<%-- 
    Document   : Perfil
    Created on : 29/11/2023, 09:42:30 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="../estilos/Perfil.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
        <link href="../estilos/PaginaPrincipal.css" rel="stylesheet" type="text/css"/>
        <script src="imageSelector.js"></script>
    </head>
    <body>

        <!-- sideBar-->
        <div class="sidebar">
            <form>
                <div class="sidebarOption HomeOption">
                    <span class="material-symbols-outlined HomeOption">home</span>
                    <!--<h2>Home</h2>-->
                    <a href="redSocial_HP.html"><h2>Home</h2></a>
                </div>
                <div class="sidebarOption">
                    <span class="material-symbols-outlined">search</span>
                    <h2>Search</h2>
                </div>
                <div class="sidebarOption">
                    <span class="material-symbols-outlined">notifications</span>
                    <h2>Notifications</h2>
                </div>
                <div class="sidebarOption">
                    <span class="material-symbols-outlined">bookmark</span>
                    <h2>Bookmark</h2>
                </div>
                <div class="sidebarOption">
                    <span class="material-symbols-outlined">person</span>
                    <a href="redSocial_profile.html"><h2>Profile</h2></a>
                </div>
                <button class="sidebar_post">Post</button>
            </form>
        </div>
        <div class="Picture_test">
            <img src="img.png"/>
            <input type="file"/>
        </div>
        <!--SideBar ends-->
    </body>
</html>
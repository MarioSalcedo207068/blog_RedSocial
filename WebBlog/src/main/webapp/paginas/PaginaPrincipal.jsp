<%-- 
    Document   : PaginaPrincipal
    Created on : 28/11/2023, 12:08:09 PM
    Author     : HP
--%>

<%@page import="dominio.Anclada"%>
<%@page import="dominio.Comentario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Administrador"%>
<%@page import="dominio.Normal"%>
<%@page import="java.util.List"%>
<%@page import="dominio.Comun"%>
<%@page import="dominio.Comun"%>
<%@page import="dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Red Social</title>
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,1,0" />
        <link href="../estilos/PaginaPrincipal.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div class="sidebar">
            <form>
                <div class="sidebarOption HomeOption">
                    <span class="material-symbols-outlined HomeOption">home</span>

                    <a href="redSocial_HP.html">
                        <h2>Home</h2>
                    </a>
                </div>

                <div class="sidebarOption">
                    <span class="material-symbols-outlined">bookmark</span>
                    <%
                        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                    %>
                    <h2><%=usuario.nombreCompleto()%></h2>

                </div>
                <div class="sidebarOption">
                    <span class="material-symbols-outlined">person</span>
                    <a href="Perfil.jsp">
                        <h2>Perfil</h2>
                    </a>
                </div>
                <button class="sidebar_post">Post</button>
            </form>
        </div>

        <div class="feed">
            <div class="feed_header">
                <h2>Home</h2>
            </div>

            <div class="AppPosts">
                <form id="formularioPubFlicacion">
                    <div class="postbox_input">
                        <img src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                             alt="notFound" />
                        <input type="text" placeholder="¿En qué piensas?" name="publicacion">
                    </div>
                    <button type="submit" class="postbox_button">Post</button>
                </form>
            </div>

            <!-- CommentPosts ends-->

            <!-- Post (feed) starts-->
            <%
                List<Comun> publicacionesComunes = (List<Comun>) request.getSession().getAttribute("publicacionesComunes");
                for (int i = publicacionesComunes.size() - 1; i >= 0; i--) {%>
            <div class="post">
                <div class="post_avatar">
                    <img src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                         alt="" />
                    <!-- https://i.pinimg.com/originals/a6/58/32/a65832155622ac173337874f02b218fb.png"-->
                </div>

                <div class="post_body">
                    <div class="post_header">
                        <div class="post_header_text">
                            <h3>
                                <%=publicacionesComunes.get(i).getUsuario().nombreCompleto()%>
                                <span class="post_headerSpecial">
                                    <span class="material-symbols-outlined badge_verified">verified</span>
                                </span>

                            </h3>
                            <%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                String formattedDate = sdf.format(publicacionesComunes.get(i).getFechaHoraCreacion().getTime());%>
                            <h4>Fecha de creación: <%=formattedDate%></h4>
                        </div>
                        <div class="post_headerDescription">
                            <p><%=publicacionesComunes.get(i).getContenido()%></p>
                        </div>
                    </div>


                    <%if (usuario instanceof Administrador) {%>
                    <div class="post_footer">
                        <button class="admin_btn" onclick="borrarPublicacion(this)">Borrar Publicación</button>
                    </div>
                    <% }%>




                    <div class="comments">
                        <h4>Comentarios</h4>
                        <%
                            List<Comentario> comentarios = publicacionesComunes.get(i).getComentarios();
                            for (int j = 0; j < comentarios.size(); j++) {%>
                        <div class="comment">
                            <img src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                                 alt="Avatar">
                            <%
                                formattedDate = sdf.format(comentarios.get(j).getFechaHora().getTime());%>
                            <h5>Fecha de creación: <%=formattedDate%></h5>

                            <p><%=comentarios.get(j).getUsuarioNormal().nombreCompleto() + ": " + comentarios.get(j).getContenido()%></p>
                        </div>
                        <%}%>
                        <%if (usuario instanceof Normal) {%>
                        <form class="comment-form" >
                            <textarea placeholder="Añadir un comentario"></textarea>
                            <button type="submit">Comentar</button>
                        </form>
                        <% }%>
                        <!-- Agrega más comentarios según sea necesario -->
                    </div>

                </div>
                <!-- Post (feed) ends-->
            </div>
            <%
                }
            %>



        </div>
        <div class="widgets">
            <div class="widgets_input">
                <span class="material-symbols-outlined widget_searchIcon">search</span>
                <input type="text" placeholder="Buscar Publicación">
            </div>

            <div class="widgets_widgetContainer">
                <div class="push_Pin">
                    <span class="material-symbols-outlined push_Pinned">push_pin
                    </span>
                    <h2>Publicaciones Ancladas</h2>
                </div>

            </div>

            <% List<Anclada> publicacionesAncladas = (List<Anclada>) request.getSession().getAttribute("publicacionesAncladas");%>
            <%if (publicacionesAncladas != null) {%>

            <%for (int i = 0; i < publicacionesAncladas.size(); i++) {%>


            <div class="post">
                <div class="post_avatar">
                    <img src="https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child.png"
                         alt="" />
                </div>

                <div class="post_body">
                    <div class="post_header">
                        <div class="post_header_text">
                            <h3>
                                <%=publicacionesAncladas.get(i).getAdmin().nombreCompleto()%>
                                <span class="post_headerSpecial">
                                    <span class="material-symbols-outlined badge_verified">verified</span>
                                </span>
                            </h3>
                            <%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    String formattedDate = sdf.format(publicacionesAncladas.get(i).getFechaHoraCreacion().getTime());%>
                            <h4>Fecha de creación: <%=formattedDate%></h4>
                        </div>
                        <div class="post_headerDescription">
                            <p><%=publicacionesAncladas.get(i).getContenido()%></p>
                        </div>

                    </div>


                    <div class="post_footer">
                        <button class="admin_btn" onclick="borrarPublicacion(this)">Borrar Publicación</button>
                    </div>

                </div>
            </div>
            <% }
            %>
            <% }
            %>
            <script src="../scripts/publicacion.js" type="text/javascript"></script>
    </body>

</html>

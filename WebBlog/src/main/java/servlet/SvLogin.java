/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import dominio.Usuario;
import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
public class SvLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String avatar = request.getParameter("avatar");
        String contrasenia = request.getParameter("contrasenia");

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        Usuario usuario = fabricaNegocio.createUsuarioNegocio().
                validarInicioUsuario(avatar, contrasenia);
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        List<Anclada> publicacionesAncladas = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesAncladas();
        if (usuario != null) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            sesion.setAttribute("publicacionesComunes", publicacionesComunes);
            sesion.setAttribute("publicacionesAncladas", publicacionesAncladas);
            response.sendRedirect(request.getContextPath() + "/paginas/PaginaPrincipal.jsp");

        }else{
            response.sendRedirect("errores.jsp");
            String msg="Favor de ingresar un usuario válido";
        }
    }

}

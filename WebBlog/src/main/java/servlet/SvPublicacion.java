/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dominio.Comun;
import dominio.Normal;
import dominio.Usuario;
import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class SvPublicacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String publicacion = request.getParameter("publicacion");

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();
        Comun publicacionComun = new Comun();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        publicacionComun.setContenido(publicacion);
        publicacionComun.setFechaHoraCreacion(Calendar.getInstance());
        publicacionComun.setTitulo("publicacion");
        publicacionComun.setUsuario(usuario);
        fabricaNegocio.createPublicacionNegocio().registrarPublicacion(publicacionComun);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Publicación enviada con éxito");

    }

}

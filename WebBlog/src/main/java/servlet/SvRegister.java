/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dominio.Comun;
import dominio.Credencial;
import dominio.Estado;
import dominio.Genero;
import dominio.Municipio;
import dominio.Normal;
import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
@WebServlet(name = "SvRegister", urlPatterns = {"/SvRegister"})
public class SvRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String estado = request.getParameter("estado");
        String ciudad = request.getParameter("ciudad");
        String municipio = request.getParameter("municipio");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        Normal usuarioNormal = new Normal();
        usuarioNormal.setNombres(nombre);
        usuarioNormal.setApellidoPaterno(apellidoPaterno);
        usuarioNormal.setApellidoMaterno(apellidoMaterno);
        usuarioNormal.setCredencial(new Credencial(usuario, contrasenia));
        usuarioNormal.setTelefono(telefono);
        usuarioNormal.setCorreo(email);
        usuarioNormal.setMunicipio(
                new Municipio(municipio, new Estado(estado)));
        usuarioNormal.setCiudad(ciudad);
        if (genero.equals("Hombre")) {
            usuarioNormal.setGenero(Genero.MASCULINO);
        } else {
            usuarioNormal.setGenero(Genero.FEMENINO);
        }

        usuarioNormal.setFechaNacimiento(Calendar.getInstance());

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        Normal UsuarioNormalNuevo = (Normal) fabricaNegocio.createUsuarioNegocio().registrarUsuario(usuarioNormal);
        List<Comun> publicacionesComunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        if (UsuarioNormalNuevo != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", UsuarioNormalNuevo);
            sesion.setAttribute("publicacionesComunes", publicacionesComunes);
            response.sendRedirect(request.getContextPath() + "/paginas/PaginaPrincipal.jsp");

        }
//        response.sendRedirect("/paginas/Login.jsp");
    }

}

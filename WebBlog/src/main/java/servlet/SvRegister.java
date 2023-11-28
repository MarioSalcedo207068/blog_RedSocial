/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
@WebServlet(name = "SvRegister", urlPatterns = {"/SvRegister"})
public class SvRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvRegister</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvRegister at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        usuarioNormal.setCredencial(new Credencial(email, contrasenia));
        usuarioNormal.setTelefono(telefono);
        usuarioNormal.setMunicipio(
                new Municipio(municipio, new Estado(estado)));
        usuarioNormal.setCiudad(ciudad);
        if (genero.equals("Hombre")) {
            usuarioNormal.setGenero(Genero.MASCULINO);
        } else {
            usuarioNormal.setGenero(Genero.FEMENINO);
        }
        usuarioNormal.setAvatar(usuario);
        usuarioNormal.setFechaNacimiento(Calendar.getInstance());

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        fabricaNegocio.createUsuarioNegocio().registrarUsuario(usuarioNormal);

        response.sendRedirect(request.getContextPath() + "/paginas/Login.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

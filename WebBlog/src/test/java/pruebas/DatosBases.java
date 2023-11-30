/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dominio.Administrador;
import dominio.Credencial;
import dominio.Estado;
import dominio.Genero;
import dominio.Municipio;
import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import java.util.Calendar;

/**
 *
 * @author HP
 */
public class DatosBases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IFabricaNegocio fabricaNegocio = new FabricaNegocio();

        Administrador administrador = new Administrador();
        administrador.setApellidoMaterno("Lopez");
        administrador.setApellidoPaterno("Lopez");
        administrador.setCiudad("Obregon");
        administrador.setCorreo("juan@gmail.com");
        administrador.setCredencial(new Credencial("juan", "1234"));
        administrador.setFechaNacimiento(Calendar.getInstance());
        administrador.setGenero(Genero.MASCULINO);
        administrador.setMunicipio(new Municipio("Cajeme", new Estado("Sonora")));
        administrador.setNombres("Juan");
        administrador.setTelefono("12314321");

        fabricaNegocio.createUsuarioNegocio().registrarUsuario(administrador);

    }

}

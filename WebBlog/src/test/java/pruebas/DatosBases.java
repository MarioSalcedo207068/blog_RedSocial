/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dominio.Administrador;
import dominio.Anclada;
import dominio.Comentario;
import dominio.Comun;
import dominio.Credencial;
import dominio.Estado;
import dominio.Genero;
import dominio.Municipio;
import dominio.Normal;
import dominio.Publicacion;
import fabrica.FabricaNegocio;
import fabrica.IFabricaNegocio;
import facade.Facade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        administrador = (Administrador) fabricaNegocio.createUsuarioNegocio().registrarUsuario(administrador);

        Normal normal = new Normal();
        normal.setApellidoMaterno("Lopez");
        normal.setApellidoPaterno("Lopez");
        normal.setCiudad("Obregon");
        normal.setCorreo("daoma@gmail.com");
        normal.setCredencial(new Credencial("daoma", "1234"));
        normal.setFechaNacimiento(Calendar.getInstance());
        normal.setGenero(Genero.MASCULINO);
        normal.setMunicipio(new Municipio("Cajeme", new Estado("Sonora")));
        normal.setNombres("Daniel");
        normal.setTelefono("12314321");
        normal = (Normal) fabricaNegocio.createUsuarioNegocio().registrarUsuario(normal);

        List<Comun> publicaciones = new ArrayList<>();
        // Publicacion 1
        Calendar fechaHoraCreacion1 = Calendar.getInstance();
        fechaHoraCreacion1.set(2023, Calendar.NOVEMBER, 29, 10, 30); // Establecer fecha y hora
        Comun publicacion1 = new Comun(normal, fechaHoraCreacion1, "Título 1", "Contenido 1");
        publicaciones.add(publicacion1);
        // Publicacion 2
        Calendar fechaHoraCreacion2 = Calendar.getInstance();
        fechaHoraCreacion2.set(2023, Calendar.NOVEMBER, 28, 14, 45);
        Comun publicacion2 = new Comun(administrador, fechaHoraCreacion2, "Título 2", "Contenido 2");
        publicaciones.add(publicacion2);
        // Publicacion 3
        Calendar fechaHoraCreacion3 = Calendar.getInstance();
        fechaHoraCreacion3.set(2023, Calendar.NOVEMBER, 27, 20, 0);
        Comun publicacion3 = new Comun(normal, fechaHoraCreacion3, "Título 3", "Contenido 3");
        publicaciones.add(publicacion3);
        // Publicacion 4
        Calendar fechaHoraCreacion4 = Calendar.getInstance();
        fechaHoraCreacion4.set(2023, Calendar.NOVEMBER, 26, 8, 15);
        Comun publicacion4 = new Comun(administrador, fechaHoraCreacion4, "Título 4", "Contenido 4");
        publicaciones.add(publicacion4);

        for (int i = 0; i < publicaciones.size(); i++) {
            fabricaNegocio.createPublicacionNegocio().registrarPublicacion(publicaciones.get(i));
        }

        List<Comun> comunes = fabricaNegocio.createPublicacionNegocio().consultarPublicacionesComunes();
        facade.Facade f = new Facade();
        for (int i = 0; i < comunes.size(); i++) {
            f.useComentarioDAO().create(new Comentario(Calendar.getInstance(), "interesante", normal, comunes.get(i)));

        }

        fabricaNegocio.createPublicacionNegocio().registrarPublicacion(
                new Anclada(administrador, Calendar.getInstance(), "La vida",
                        "Es bonita"));

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
import dominio.Usuario;
import facade.Facade;
import facade.IFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author HP
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IFacade facade = new Facade();

        //Registrar Uuario normal
        Normal usuario = new Normal("Daniel", "Lopez", "Lopez", "6442121807",
                "Daoma", "cd. obregon", new GregorianCalendar(2, 2, 1994), Genero.MASCULINO,
                new Credencial("daoma@hotmail.com", "1234"),
                new Municipio("cajeme", new Estado("Sonora")));

        usuario = facade.useNormalDAO().create(usuario);

        Normal UsuNormal = usuario;
        //Validar inicio de sesion
        List<Usuario> usuarios = facade.useUsuarioDAO().findUsuarioEntities();
        String correo = "daoma@hotmail.com";
        String contrasenia = "1234";

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCredencial().getCorreo().equals(correo)
                    && usuarios.get(i).getCredencial().getContrasenia().equals(contrasenia)) {

                System.out.println("Bienvenido " + usuarios.get(i).getNombres());
            }
        }
        //Registrar publicacion
        Comun publicacion = new Comun(UsuNormal, Calendar.getInstance(),
                "El mundo", "Que bonito esta");

        publicacion = facade.useComunDAO().create(publicacion);
        //Registrar comentario
        Comentario comentario = new Comentario(Calendar.getInstance(),
                "Interesante", UsuNormal, publicacion);

        //Registrar comentario anclado
        Comentario comentario1 = new Comentario(Calendar.getInstance(),
                "Interesante 2", UsuNormal, publicacion);
        comentario1.setComentarioPadre(comentario);

        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(comentario1);

        comentario.setComentarios(comentarios);

        facade.useComentarioDAO().create(comentario);

        //Editar Publicacion
        publicacion.setContenido("Que bonito esta 2");
        facade.useComunDAO().edit(publicacion);

        //Crear publicacion anclada
        Administrador administrador = new Administrador("Ana", "García", "Martínez", "5551234567",
                "Calle Principal 123", "Ciudad de México", new GregorianCalendar(15, 8, 1990), Genero.FEMENINO,
                new Credencial("ana@gmail.com", "abcd5678"),
                new Municipio("Benito Juárez", new Estado("Ciudad de México")));

        Anclada anclada = new Anclada(administrador, Calendar.getInstance(), "El universo", "impresionante");
        anclada.setAdmin(administrador);
        facade.useAncladaDAO().create(anclada);

        // Permite consultar todas las publicaciones
        System.out.println("Publicaciones");
        List<Publicacion> publicaciones = facade.usePublicacionDAO().findPublicacionEntities();
        for (int i = 0; i < publicaciones.size(); i++) {
            System.out.println(publicaciones.toString());
        }

        //Permite consultar los comentarios de las publicaciones
        comentarios = facade.useComentarioDAO().findComentarioEntities();
        System.out.println("Comentarios");
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getPublicacionComun().equals(publicacion)) {
                System.out.println(comentarios.get(i).toString());
            }
        }
        //Permite eliminar comentarios
        facade.useComentarioDAO().destroy(comentario.getId());
        //Permite eliminar publicaciones
        facade.useComunDAO().destroy(publicacion.getId());

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa una publicación común en el sistema.
 */
public class Comun extends Publicacion {

    private Usuario usuario;
    private List<Comentario> comentarios;

    /**
     * Constructor por defecto de la clase Comun.
     */
    public Comun() {
    }

    /**
     * Constructor que recibe el usuario asociado a la publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     */
    public Comun(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comun(Usuario usuario, Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
        this.usuario = usuario;
    }

    /**
     * Constructor que recibe el usuario asociado, la fecha y hora de creación,
     * el título, el contenido y la fecha y hora de edición de la publicación
     * común.
     *
     * @param usuario El usuario asociado a la publicación común.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * común.
     * @param titulo El título de la publicación común.
     * @param contenido El contenido de la publicación común.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * común.
     */
    public Comun(Usuario usuario, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    
}
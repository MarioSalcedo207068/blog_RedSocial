/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * Clase que representa una publicación común en el sistema.
 */
@Entity
@DiscriminatorValue(value = "comun")
public class Comun extends Publicacion {

    //Relaciones
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

    public Comun(Usuario usuario, Calendar fechaHoraCreacion, String titulo,
            String contenido) {
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
    public Comun(Usuario usuario, Calendar fechaHoraCreacion, String titulo,
            String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    /**
     * Constructor que recibe el usuario asociado, el ID, la fecha y hora de
     * creación, el título, el contenido y la fecha y hora de edición de la
     * publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     * @param id El ID de la publicación común.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * común.
     * @param titulo El título de la publicación común.
     * @param contenido El contenido de la publicación común.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * común.
     */
    public Comun(Usuario usuario, Long id, Calendar fechaHoraCreacion, String titulo,
            String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    /**
     * Obtiene el usuario asociado a la publicación común.
     *
     * @return El usuario asociado a la publicación común.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a la publicación común.
     *
     * @param usuario El usuario asociado a la publicación común.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de comentarios asociados a la publicación común.
     *
     * @return La lista de comentarios asociados a la publicación común.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios asociados a la publicación común.
     *
     * @param comentarios La lista de comentarios asociados a la publicación
     * común.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Comun{" + "usuario=" + usuario + ", comentarios=" + comentarios + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que representa una publicación anclada en el sistema. Hereda de la
 * clase Publicacion.
 */
@Entity
@DiscriminatorValue(value = "anclada")
public class Anclada extends Publicacion implements Serializable {

    //Relaciones
    @ManyToOne()
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    /**
     * Constructor por defecto de la clase Anclada.
     */
    public Anclada() {
    }

    public Anclada(Administrador admin, Calendar fechaHoraCreacion, String titulo,
            String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
        this.administrador = admin;
    }

    /**
     * Constructor que recibe un administrador para la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public Anclada(Administrador admin) {
        this.administrador = admin;
    }

    /**
     * Constructor que recibe un administrador, la fecha y hora de creación, el
     * título, el contenido y la fecha y hora de edición de la publicación
     * anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * anclada.
     * @param titulo El título de la publicación anclada.
     * @param contenido El contenido de la publicación anclada.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * anclada.
     */
    public Anclada(Administrador admin, Calendar fechaHoraCreacion, String titulo,
            String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.administrador = admin;
    }

    /**
     * Constructor que recibe un administrador, el ID, la fecha y hora de
     * creación, el título, el contenido y la fecha y hora de edición de la
     * publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     * @param id El ID de la publicación anclada.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación
     * anclada.
     * @param titulo El título de la publicación anclada.
     * @param contenido El contenido de la publicación anclada.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación
     * anclada.
     */
    public Anclada(Administrador administrador, Long id, Calendar fechaHoraCreacion,
            String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(id, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.administrador = administrador;
    }

    /**
     * Obtiene el administrador asociado a la publicación anclada.
     *
     * @return El administrador asociado a la publicación anclada.
     */
    public Administrador getAdmin() {
        return administrador;
    }

    /**
     * Establece el administrador asociado a la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public void setAdmin(Administrador admin) {
        this.administrador = admin;
    }

}

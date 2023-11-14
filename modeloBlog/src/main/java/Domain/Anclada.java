/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que representa una publicación anclada en el sistema. Hereda de la
 * clase Publicacion.
 */
@Entity
@DiscriminatorValue(value = "anclada")
public class Anclada extends Publicacion {

    //Relaciones
    private Administrador admin;

    /**
     * Constructor por defecto de la clase Anclada.
     */
    public Anclada() {
    }

    public Anclada(Administrador admin, Calendar fechaHoraCreacion, String titulo,
            String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
        this.admin = admin;
    }

    /**
     * Constructor que recibe un administrador para la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public Anclada(Administrador admin) {
        this.admin = admin;
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
        this.admin = admin;
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
        this.admin = administrador;
    }

    /**
     * Obtiene el administrador asociado a la publicación anclada.
     *
     * @return El administrador asociado a la publicación anclada.
     */
    public Administrador getAdmin() {
        return admin;
    }

    /**
     * Establece el administrador asociado a la publicación anclada.
     *
     * @param admin El administrador asociado a la publicación anclada.
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

/**
 * Clase que representa una publicación.
 */
@Entity
@Table(name = "publicacion")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Publicacion implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHoraCreacion;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    @Column(name = "fechaEdicion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHoraEdicion;

    /**
     * Constructor por defecto de la clase Publicacion.
     */
    public Publicacion() {
    }

    public Publicacion(Calendar fechaHoraCreacion, String titulo, String contenido) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     * Constructor de la clase Publicacion.
     *
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     * @param titulo El título de la publicación.
     * @param contenido El contenido de la publicación.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación.
     */
    public Publicacion(Calendar fechaHoraCreacion, String titulo, String contenido,
            Calendar fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Constructor de la clase Publicacion.
     *
     * @param id El ID de la publicación.
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     * @param titulo El título de la publicación.
     * @param contenido El contenido de la publicación.
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación.
     */
    public Publicacion(Long id, Calendar fechaHoraCreacion, String titulo,
            String contenido, Calendar fechaHoraEdicion) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Obtiene el ID de la publicación.
     *
     * @return El ID de la publicación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la publicación.
     *
     * @param id El ID de la publicación.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de creación de la publicación.
     *
     * @return La fecha y hora de creación de la publicación.
     */
    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación de la publicación.
     *
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     */
    public void setFechaHoraCreacion(Calendar fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Obtiene el título de la publicación.
     *
     * @return El título de la publicación.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     *
     * @param titulo El título de la publicación.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el contenido de la publicación.
     *
     * @return El contenido de la publicación.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la publicación.
     *
     * @param contenido El contenido de la publicación.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha y hora de edición de la publicación.
     *
     * @return La fecha y hora de edición de la publicación.
     */
    public Calendar getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora de edición de la publicación.
     *
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación.
     */
    public void setFechaHoraEdicion(Calendar fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }

}

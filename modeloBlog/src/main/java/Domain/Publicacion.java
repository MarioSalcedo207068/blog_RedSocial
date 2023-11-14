/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa una publicación.
 */
public class Publicacion {

    private int id;
    private Date fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private Date fechaHoraEdicion;

    /**
     * Constructor por defecto de la clase Publicacion.
     */
    public Publicacion() {
    }

    public Publicacion(Date fechaHoraCreacion, String titulo, String contenido) {
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
    public Publicacion(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
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
    public Publicacion(int id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
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
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la publicación.
     *
     * @param id El ID de la publicación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de creación de la publicación.
     *
     * @return La fecha y hora de creación de la publicación.
     */
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación de la publicación.
     *
     * @param fechaHoraCreacion La fecha y hora de creación de la publicación.
     */
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
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
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora de edición de la publicación.
     *
     * @param fechaHoraEdicion La fecha y hora de edición de la publicación.
     */
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
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

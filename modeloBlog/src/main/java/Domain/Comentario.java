/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un comentario en el sistema.
 */
public class Comentario {

    private int id;
    private Date fechaHora;
    private String contenido;
    private Normal usuarioNormal;
    private Comun publicacionComun;
    private List<Comentario> comentarios;

    /**
     * Constructor por defecto de la clase Comentario.
     */
    public Comentario() {
    }

    /**
     * Constructor que recibe la fecha y hora, el contenido, el usuario normal y
     * la publicación común asociados al comentario.
     *
     * @param fechaHora La fecha y hora del comentario.
     * @param contenido El contenido del comentario.
     * @param usuarioNormal El usuario normal asociado al comentario.
     * @param publicacionComun La publicación común asociada al comentario.
     */
    public Comentario(Date fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
    }

    /**
     * Constructor que recibe el ID, la fecha y hora, el contenido, el usuario
     * normal, la publicación común y la lista de comentarios asociados al
     * comentario.
     *
     * @param id El ID del comentario.
     * @param fechaHora La fecha y hora del comentario.
     * @param contenido El contenido del comentario.
     * @param usuarioNormal El usuario normal asociado al comentario.
     * @param publicacionComun La publicación común asociada al comentario.
     * @param comentarios La lista de comentarios asociados al comentario.
     */
    public Comentario(int id, Date fechaHora, String contenido, Normal usuarioNormal, Comun publicacionComun, List<Comentario> comentarios) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.publicacionComun = publicacionComun;
        this.comentarios = comentarios;
    }

    /**
     * Obtiene el ID del comentario.
     *
     * @return El ID del comentario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del comentario.
     *
     * @param id El ID del comentario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora del comentario.
     *
     * @return La fecha y hora del comentario.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del comentario.
     *
     * @param fechaHora La fecha y hora del comentario.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return El contenido del comentario.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido El contenido del comentario.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el usuario normal asociado al comentario.
     *
     * @return El usuario normal asociado al comentario.
     */
    public Normal getUsuarioNormal() {
        return usuarioNormal;
    }

    /**
     * Establece el usuario normal asociado al comentario.
     *
     * @param usuarioNormal El usuario normal asociado al comentario.
     */
    public void setUsuarioNormal(Normal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    /**
     * Obtiene la publicación común asociada al comentario.
     *
     * @return La publicación común asociada al comentario.
     */
    public Comun getPublicacionComun() {
        return publicacionComun;
    }

    /**
     * Establece la publicación común asociada al comentario.
     *
     * @param publicacionComun La publicación común asociada al comentario.
     */
    public void setPublicacionComun(Comun publicacionComun) {
        this.publicacionComun = publicacionComun;
    }

    /**
     * Obtiene la lista de comentarios asociados al comentario.
     *
     * @return La lista de comentarios asociados al comentario.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios asociados al comentario.
     *
     * @param comentarios La lista de comentarios asociados al comentario.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuarioNormal=" + usuarioNormal + ", publicacionComun=" + publicacionComun + ", comentarios=" + comentarios + '}';
    }

}
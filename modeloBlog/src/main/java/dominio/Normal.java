/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * Clase que representa a un usuario normal.
 */
@Entity
@DiscriminatorValue(value = "normal")
public class Normal extends Usuario implements Serializable {

    //Relaciones
    @OneToMany(mappedBy = "usuarioNormal", cascade = CascadeType.REMOVE)
    private List<Comentario> comenatarios;

    public Normal() {
    }

    public Normal(String nombres, String apellidoPaterno, String apellidoMaterno,
            String telefono, String avatar, String ciudad, Calendar fechaNacimiento,
            Genero genero, Credencial credencial, Municipio municipio) {
        super(nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad,
                fechaNacimiento, genero, credencial, municipio);
    }

    public Normal(Long id, String nombres, String apellidoPaterno, String apellidoMaterno,
            String telefono, String avatar, String ciudad, Calendar fechaNacimiento, Genero genero,
            Credencial credencial, Municipio municipio) {
        super(id, nombres, apellidoPaterno, apellidoMaterno, telefono, avatar, ciudad,
                fechaNacimiento, genero, credencial, municipio);
    }

    /**
     * Obtiene la lista de comentarios del usuario normal.
     *
     * @return La lista de comentarios del usuario normal.
     */
    public List<Comentario> getComenatarios() {
        return comenatarios;
    }

    /**
     * Establece la lista de comentarios del usuario normal.
     *
     * @param comentarios La lista de comentarios del usuario normal.
     */
    public void setComenatarios(List<Comentario> comenatarios) {
        this.comenatarios = comenatarios;
    }

}

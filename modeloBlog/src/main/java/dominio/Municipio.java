/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author aleja
 */
/**
 * Clase que representa un municipio en un estado.
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "municipio")
    private List<Usuario> usuarios;

    /**
     * Constructor por defecto de la clase Municipio.
     */
    public Municipio() {
    }

    /**
     * Constructor que recibe el nombre y el estado del municipio.
     *
     * @param nombre El nombre del municipio.
     * @param estado El estado al que pertenece el municipio.
     */
    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    /**
     * Constructor que recibe el nombre, el estado y la lista de usuarios del
     * municipio.
     *
     * @param nombre El nombre del municipio.
     * @param estado El estado al que pertenece el municipio.
     * @param usuarios La lista de usuarios del municipio.
     */
    public Municipio(String nombre, Estado estado, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Constructor que recibe el ID, el nombre, el estado y la lista de usuarios
     * del municipio.
     *
     * @param id El ID del municipio.
     * @param nombre El nombre del municipio.
     * @param estado El estado al que pertenece el municipio.
     * @param usuarios La lista de usuarios del municipio.
     */
    public Municipio(Long id, String nombre, Estado estado, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Obtiene el ID del municipio.
     *
     * @return El ID del municipio.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del municipio.
     *
     * @param id El ID del municipio.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del municipio.
     *
     * @return El nombre del municipio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     *
     * @param nombre El nombre del municipio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado al que pertenece el municipio.
     *
     * @return El estado al que pertenece el municipio.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado al que pertenece el municipio.
     *
     * @param estado El estado al que pertenece el municipio.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la lista de usuarios del municipio.
     *
     * @return La lista de usuarios del municipio.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios del municipio.
     *
     * @param usuarios La lista de usuarios del municipio.
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", usuarios=" + usuarios + '}';
    }

}

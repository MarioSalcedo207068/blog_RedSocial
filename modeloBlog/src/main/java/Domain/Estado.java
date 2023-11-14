/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author aleja
 */
@Entity
@Table(name = "estado")
public class Estado {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    //Relaciones
    private List<Municipio> municipos;

    /**
     * Constructor por defecto de la clase Estado.
     */
    public Estado() {
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que recibe el nombre y la lista de municipios del estado.
     *
     * @param nombre El nombre del estado.
     * @param municipos La lista de municipios del estado.
     */
    public Estado(String nombre, List<Municipio> municipos) {
        this.nombre = nombre;
        this.municipos = municipos;
    }

    /**
     * Constructor que recibe el ID, el nombre y la lista de municipios del
     * estado.
     *
     * @param id El ID del estado.
     * @param nombre El nombre del estado.
     * @param municipos La lista de municipios del estado.
     */
    public Estado(Long id, String nombre, List<Municipio> municipos) {
        this.id = id;
        this.nombre = nombre;
        this.municipos = municipos;
    }

    /**
     * Obtiene el ID del estado.
     *
     * @return El ID del estado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del estado.
     *
     * @param id El ID del estado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado.
     *
     * @return El nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     *
     * @param nombre El nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de municipios del estado.
     *
     * @return La lista de municipios del estado.
     */
    public List<Municipio> getMunicipos() {
        return municipos;
    }

    /**
     * Establece la lista de municipios del estado.
     *
     * @param municipos La lista de municipios del estado.
     */
    public void setMunicipos(List<Municipio> municipos) {
        this.municipos = municipos;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nombre=" + nombre + ", municipos=" + municipos + '}';
    }

}

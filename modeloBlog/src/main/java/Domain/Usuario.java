/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un usuario.
 */
public class Usuario {

    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private Genero genero;
    private Credencial credencial;
    private Municipio municipio;
    private List<Comun> publicacionesComunes;

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    public Usuario(String nombres, Credencial credencial) {
        this.nombres = nombres;
        this.credencial = credencial;
    }

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombres Los nombres del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     * @param telefono El número de teléfono del usuario.
     * @param avatar La URL del avatar del usuario.
     * @param ciudad La ciudad del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param genero El género del usuario.
     * @param credencial Las credenciales del usuario.
     * @param municipio El municipio del usuario.
     */
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.credencial = credencial;
        this.municipio = municipio;
    }

    /**
     * Constructor de la clase Usuario.
     *
     * @param id El ID del usuario.
     * @param nombres Los nombres del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     * @param telefono El número de teléfono del usuario.
     * @param avatar La URL del avatar del usuario.
     * @param ciudad La ciudad del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param genero El género del usuario.
     * @param credencial Las credenciales del usuario.
     * @param municipio El municipio del usuario.
     */
    public Usuario(int id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.credencial = credencial;
        this.municipio = municipio;
    }

}
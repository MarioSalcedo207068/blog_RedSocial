/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import javax.persistence.*;

/**
 *
 * @author aleja
 */
@Entity
@Table(name = "credencial")
public class Credencial {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo", nullable = false, length = 200, unique = true)
    private String correo;

    @Column(name = "contrasenia", nullable = false, length = 200)
    private String contrasenia;

    /**
     * Constructor por defecto de la clase Credencial.
     */
    public Credencial() {
    }

    /**
     * Constructor que recibe el correo y la contraseña de las credenciales.
     *
     * @param correo El correo de las credenciales.
     * @param contrasenia La contraseña de las credenciales.
     */
    public Credencial(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que recibe el correo y la contraseña de las credenciales.
     *
     * @param id El id de la credencial
     * @param correo El correo de las credenciales.
     * @param contrasenia La contraseña de las credenciales.
     */
    public Credencial(Long id, String correo, String contrasenia) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el correo de las credenciales.
     *
     * @return El correo de las credenciales.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo de las credenciales.
     *
     * @param correo El correo de las credenciales.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña de las credenciales.
     *
     * @return La contraseña de las credenciales.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña de las credenciales.
     *
     * @param contrasenia La contraseña de las credenciales.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el id de la credencial.
     *
     * @return El id de la credenciale.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id de la credencial.
     *
     * @param id El id de la credencial.
     */
    public void setId(Long id) {
        this.id = id;
    }

}

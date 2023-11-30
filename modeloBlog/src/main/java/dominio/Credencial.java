/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author aleja
 */
@Entity
@Table(name = "credencial")
public class Credencial implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avatar", nullable = false, length = 200, unique = true)
    private String avatar;

    @Column(name = "contrasenia", nullable = false, length = 200)
    private String contrasenia;

    /**
     * Constructor por defecto de la clase Credencial.
     */
    public Credencial() {
    }

    public Credencial(String avatar, String contrasenia) {
        this.avatar = avatar;
        this.contrasenia = contrasenia;
    }

    public Credencial(Long id, String avatar, String contrasenia) {
        this.id = id;
        this.avatar = avatar;
        this.contrasenia = contrasenia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

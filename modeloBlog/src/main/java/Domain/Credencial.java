/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author aleja
 */
public class Credencial {

    private String correo;
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

}

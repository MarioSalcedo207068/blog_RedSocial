package Domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un usuario.
 */
public class Usuario {

    private Long id;
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
    public Usuario(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String avatar, String ciudad, Date fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
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

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del usuario.
     *
     * @return Los nombres del usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del usuario.
     *
     * @param nombres Los nombres del usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El apellido paterno del usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El apellido materno del usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono El número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la URL del avatar del usuario.
     *
     * @return La URL del avatar del usuario.
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Establece la URL del avatar del usuario.
     *
     * @param avatar La URL del avatar del usuario.
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Obtiene la ciudad del usuario.
     *
     * @return La ciudad del usuario.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del usuario.
     *
     * @param ciudad La ciudad del usuario.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el género del usuario.
     *
     * @return El género del usuario.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero El género del usuario.
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene las credenciales del usuario.
     *
     * @return Las credenciales del usuario.
     */
    public Credencial getCredencial() {
        return credencial;
    }

    /**
     * Establece las credenciales del usuario.
     *
     * @param credencial Las credenciales del usuario.
     */
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    /**
     * Obtiene el municipio del usuario.
     *
     * @return El municipio del usuario.
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio del usuario.
     *
     * @param municipio El municipio del usuario.
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene las publicaciones comunes del usuario.
     *
     * @return Las publicaciones comunes del usuario.
     */
    public List<Comun> getPublicacionesComunes() {
        return publicacionesComunes;
    }

    /**
     * Establece las publicaciones comunes del usuario.
     *
     * @param publicacionesComunes Las publicaciones comunes del usuario.
     */
    public void setPublicacionesComunes(List<Comun> publicacionesComunes) {
        this.publicacionesComunes = publicacionesComunes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", credencial=" + credencial + ", municipio=" + municipio + ", publicacionesComunes=" + publicacionesComunes + '}';
    }

}

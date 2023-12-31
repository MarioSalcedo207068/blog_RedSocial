package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * Clase que representa un usuario.
 */
@Entity
@Table(name = "usuario")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 200)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 200)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 200)
    private String apellidoMaterno;

    @Column(name = "telefono", nullable = false, length = 12)
    private String telefono;

    @Column(name = "correo", nullable = false, length = 200, unique = true)
    private String correo;

    @Column(name = "ciudad", nullable = false, length = 200)
    private String ciudad;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

    //Relaciones
    //Relación con credencial
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "credencial_id", unique = true)
    private Credencial credencial;

    //Relación con municipio
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;

    //Relación con usuario
    @OneToMany(mappedBy = "usuario")
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

    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, String ciudad, Calendar fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.credencial = credencial;
        this.municipio = municipio;
    }

    public Usuario(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, String ciudad, Calendar fechaNacimiento, Genero genero, Credencial credencial, Municipio municipio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
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
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
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

    public String nombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

}

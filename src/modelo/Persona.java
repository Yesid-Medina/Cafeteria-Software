
package modelo;

/**
 *
 * @author Omar Medina
 */
public class Persona {
    private String nroDocumento;
    private String tipoDocumento;
    private String apellidos;
    private String nombre;
    private String email;
    private String estado;

    public Persona() {
    }

    public Persona(String nroDocumento, String tipoDocumento, String apellidos, String nombre, String email, String estado) {
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "nroDocumento=" + nroDocumento + ", tipoDocumento=" + tipoDocumento + ", apellidos=" + apellidos + ", nombre=" + nombre + ", email=" + email + ", estado=" + estado + '}';
    }

    
}

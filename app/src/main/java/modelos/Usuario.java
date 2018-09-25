package modelos;

public class Usuario {

    private String usuario;
    private String nombre;
    private String apellido;
    private String password;
    private String serie;

    public Usuario(){

    }

    public Usuario(String usuario, String nombre, String apellido, String password, String serie){
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.serie = serie;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

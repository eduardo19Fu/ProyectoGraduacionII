package modelos;

import java.util.Date;

public class Persona {

    private Cuenta cuenta;
    private String nombre;
    private String apellido;
    private Date fecha_creacion;
    private String nit;
    private String identificacion;
    private String tipo_identificacion;
    private String correo_electronico;
    private String telefono;

    public Persona(){

    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setFecha_creacion(Date fecha_creacion){
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_creacion(){
        return this.fecha_creacion;
    }

    public void setNit(String nit){
        this.nit = nit;
    }

    public String getNit(){
        return this.nit;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }

    public String getIdentificacion(){
        return this.identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion){
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getTipo_identificacion(){
        return this.tipo_identificacion;
    }

    public void setCorreo_electronico(String correo_electronico){
        this.correo_electronico = correo_electronico;
    }

    public String getCorreo_electronico(){
        return this.correo_electronico;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return this.telefono;
    }
}
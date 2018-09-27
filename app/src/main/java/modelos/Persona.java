package modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Persona {

    @SerializedName("idpersona")
    @Expose
    private int idpersona;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellido")
    @Expose
    private String apellido;
    @SerializedName("fecha_creacion")
    @Expose
    private Date fecha_creacion;
    @SerializedName("nit")
    @Expose
    private String nit;
    @SerializedName("identificacion")
    @Expose
    private String identificacion;
    @SerializedName("tipo_identificacion")
    @Expose
    private String tipo_identificacion;
    @SerializedName("correo_electronico")
    @Expose
    private String correo_electronico;
    @SerializedName("telefono")
    @Expose
    private String telefono;

    public Persona(){

    }


    public void setIdpersona(int idpersona){
        this.idpersona = idpersona;
    }

    public int getIdpersona(){
        return this.idpersona;
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
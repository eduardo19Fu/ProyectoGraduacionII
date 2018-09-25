package modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Cuenta {

    @SerializedName("idcuenta")
    @Expose
    private int idcuenta;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("no_contador")
    @Expose
    private String no_contador;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("idbarrio")
    @Expose
    private int idbarrio;
    @SerializedName("orden_lectura")
    @Expose
    private int orden_lectura;
    @SerializedName("marchamo")
    @Expose
    private String marchamo;
    @SerializedName("tipo_servicio")
    @Expose
    private String tipo_servicio;
    @SerializedName("idpersona")
    @Expose
    private int idpersona;
    @SerializedName("voltios_solicitados")
    @Expose
    private int voltios_solicitados;
    @SerializedName("lectura_acumulada")
    @Expose
    private int lectura_acumulada;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("zona")
    @Expose
    private String zona;
    @SerializedName("dia_visita")
    @Expose
    private int dia_visita;
    @SerializedName("referencia")
    @Expose
    private String referecia;
    @SerializedName("usuario_lectura")
    @Expose
    private String usuario_lectura;
    @SerializedName("fecha_siguiente_visita")
    @Expose
    private Date fecha_siguiente_visita;
    @SerializedName("potencia_contratada")
    @Expose
    private int potencia_contratada;
    @SerializedName("poste")
    @Expose
    private String poste;
    @SerializedName("latitud")
    @Expose
    private String latitud;
    @SerializedName("longitud")
    @Expose
    private String longitud;

    public Cuenta(){

    }

    public void setIdcuenta(int idcuenta){
        this.idcuenta = idcuenta;
    }

    public int getIdcuenta(){
        return this.idcuenta;
    }

    public void setClave(String clave){
        this.clave = clave;
    }

    public String getClave(){
        return this.clave;
    }

    public void setNo_contador(String no_contador){
        this.no_contador = no_contador;
    }

    public String getNo_contador(){
        return this.no_contador;
    }

    public void setIdbarrio(int idbarrio){
        this.idbarrio = idbarrio;
    }

    public int getIdbarrio(){
        return this.idbarrio;
    }

    public void setOrden_lectura(int orden_lectura){
        this.orden_lectura = orden_lectura;
    }

    public int getOrden_lectura(){
        return this.orden_lectura;
    }

    public void setMarchamo(String marchamo){
        this.marchamo = marchamo;
    }

    public String getMarchamo(){
        return this.marchamo;
    }

    public void setTipo_servicio(String tipo_servicio){
        this.tipo_servicio = tipo_servicio;
    }

    public String getTipo_servicio(){
        return this.tipo_servicio;
    }

    public void setIdpersona(int idpersona){
        this.idpersona = idpersona;
    }

    public int getIdpersona(){
        return this.idpersona;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setVoltios_solicitados(int voltios_solicitados){
        this.voltios_solicitados = voltios_solicitados;
    }

    public int getVoltios_solicitados(){
        return this.voltios_solicitados;
    }

    public void setLectura_acumulada(int lectura_acumulada){
        this.lectura_acumulada = lectura_acumulada;
    }

    public int getLectura_acumulada(){
        return this.lectura_acumulada;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setZona(String zona){
        this.zona = zona;
    }

    public String getZona(){
        return this.zona;
    }

    public void setDia_visita(int dia_visita){
        this.dia_visita = dia_visita;
    }

    public int getDia_visita(){
        return this.dia_visita;
    }

    public void setReferecia(String referecia){
        this.referecia = referecia;
    }

    public String getReferecia(){
        return this.referecia;
    }

    public void setUsuario_lectura(String usuario_lectura){
        this.usuario_lectura = usuario_lectura;
    }

    public String getUsuario_lectura(){
        return this.usuario_lectura;
    }

    public void setFecha_siguiente_visita(Date fecha_siguiente_visita){
        this.fecha_siguiente_visita = fecha_siguiente_visita;
    }

    public Date getFecha_siguiente_visita(){
        return this.fecha_siguiente_visita;
    }

    public void setPotencia_contratada(int potencia_contratada){
        this.potencia_contratada = potencia_contratada;
    }

    public int getPotencia_contratada(){
        return this.potencia_contratada;
    }

    public void setPoste(String poste){
        this.poste = poste;
    }

    public String getPoste(){
        return this.poste;
    }

    public void setLatitud(String latitud){
        this.latitud = latitud;
    }

    public String getLatitud(){
        return this.latitud;
    }

    public void setLongitud(String longitud){
        this.longitud = longitud;
    }

    public String getLongitud(){
        return this.longitud;
    }

    @Override
    public String toString(){
        return "POST{" +
               "usuario_lectura='" + usuario_lectura + '\'' +
                ", dia_visita=" + dia_visita + '}';
    }
}

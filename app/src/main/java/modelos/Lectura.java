package modelos;

import java.util.Date;

public class Lectura {

    private int idregistro;
    private int idcuenta;
    private int energia_consumida;
    private double alumbrado;
    private double valor_consumo;
    private String tipo_tarifa;
    private double total;
    private double cargo_fijo;
    private Date fecha_lectura;
    private double iva;
    private String usuario_lectura;
    private double cargo_potencia_max;
    private double cargo_potencia_contratada;
    private int lectura_anterior;
    private int lectura_actual;

    public Lectura() {
    }

    public int getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(int idregistro) {
        this.idregistro = idregistro;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getEnergia_consumida() {
        return energia_consumida;
    }

    public void setEnergia_consumida(int energia_consumida) {
        this.energia_consumida = energia_consumida;
    }

    public double getAlumbrado() {
        return alumbrado;
    }

    public void setAlumbrado(double alumbrado) {
        this.alumbrado = alumbrado;
    }

    public double getValor_consumo() {
        return valor_consumo;
    }

    public void setValor_consumo(double valor_consumo) {
        this.valor_consumo = valor_consumo;
    }

    public String getTipo_tarifa() {
        return tipo_tarifa;
    }

    public void setTipo_tarifa(String tipo_tarifa) {
        this.tipo_tarifa = tipo_tarifa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCargo_fijo() {
        return cargo_fijo;
    }

    public void setCargo_fijo(double cargo_fijo) {
        this.cargo_fijo = cargo_fijo;
    }

    public Date getFecha_lectura() {
        return fecha_lectura;
    }

    public void setFecha_lectura(Date fecha_lectura) {
        this.fecha_lectura = fecha_lectura;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getUsuario_lectura() {
        return usuario_lectura;
    }

    public void setUsuario_lectura(String usuario_lectura) {
        this.usuario_lectura = usuario_lectura;
    }

    public double getCargo_potencia_max() {
        return cargo_potencia_max;
    }

    public void setCargo_potencia_max(double cargo_potencia_max) {
        this.cargo_potencia_max = cargo_potencia_max;
    }

    public double getCargo_potencia_contratada() {
        return cargo_potencia_contratada;
    }

    public void setCargo_potencia_contratada(double cargo_potencia_contratada) {
        this.cargo_potencia_contratada = cargo_potencia_contratada;
    }

    public int getLectura_anterior() {
        return lectura_anterior;
    }

    public void setLectura_anterior(int lectura_anterior) {
        this.lectura_anterior = lectura_anterior;
    }

    public int getLectura_actual() {
        return lectura_actual;
    }

    public void setLectura_actual(int lectura_actual) {
        this.lectura_actual = lectura_actual;
    }
}

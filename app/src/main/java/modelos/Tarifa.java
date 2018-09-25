package modelos;

import java.math.BigDecimal;

public class Tarifa {

    private int idtipo;
    private String tipo_tarifa;
    private int valor_inicial;
    private int valor_final;
    private double valor;
    private double cargoFijo;
    private double cargo_potencia_maxima;
    private double cargo_potencia_contratada;
    private double alumbrado_publico;

    public Tarifa(){

    }

    public Tarifa(int idtipo, String tipo_tarifa, int valor_inicial, int valor_final, double valor, double cargoFijo,
                  double cargo_potencia_maxima, double cargo_potencia_contratada, double alumbrado_publico)
    {
        this.idtipo = idtipo;
        this.tipo_tarifa = tipo_tarifa;
        this.valor_inicial = valor_inicial;
        this.valor_final = valor_final;
        this.valor = valor;
        this.cargoFijo = cargoFijo;
        this.cargo_potencia_maxima = cargo_potencia_maxima;
        this.cargo_potencia_contratada = cargo_potencia_contratada;
        this.alumbrado_publico = alumbrado_publico;
    }

    public void setIdtipo(int idtipo){
        this.idtipo = idtipo;
    }

    public int getIdtipo(){
        return this.idtipo;
    }

    public void setTipo_tarifa(String tipo_tarifa){
        this.tipo_tarifa = tipo_tarifa;
    }

    public String getTipo_tarifa(){
        return this.tipo_tarifa;
    }

    public void setValor_inicial(int valor_inicial){
        this.valor_inicial = valor_inicial;
    }

    public int getValor_inicial(){
        return this.valor_inicial;
    }

    public void setValor_final(int valor_final){
        this.valor_final = valor_final;
    }

    public int getValor_final(){
        return this.valor_final;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setCargoFijo(double cargoFijo) {
        this.cargoFijo = cargoFijo;
    }

    public double getCargoFijo() {
        return this.cargoFijo;
    }

    public void setCargo_potencia_maxima(double cargo_potencia_maxima) {
        this.cargo_potencia_maxima = cargo_potencia_maxima;
    }

    public double getCargo_potencia_maxima() {
        return this.cargo_potencia_maxima;
    }

    public void setCargo_potencia_contratada(double cargo_potencia_contratada) {
        this.cargo_potencia_contratada = cargo_potencia_contratada;
    }

    public double getCargo_potencia_contratada() {
        return this.cargo_potencia_contratada;
    }

    public void setAlumbrado_publico(double alumbrado_publico) {
        this.alumbrado_publico = alumbrado_publico;
    }

    public double getAlumbrado_publico() {
        return this.alumbrado_publico;
    }
}

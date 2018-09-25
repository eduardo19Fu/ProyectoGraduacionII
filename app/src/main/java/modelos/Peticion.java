package modelos;

public class Peticion {

    private int dia_visita;
    private String usuario_lectura;

    public Peticion(int dia_visita, String usuario_lectura) {
        this.dia_visita = dia_visita;
        this.usuario_lectura = usuario_lectura;
    }

    public int getDia_visita() {
        return dia_visita;
    }

    public void setDia_visita(int dia_visita) {
        this.dia_visita = dia_visita;
    }

    public String getUsuario_lectura() {
        return usuario_lectura;
    }

    public void setUsuario_lectura(String usuario_lectura) {
        this.usuario_lectura = usuario_lectura;
    }
}

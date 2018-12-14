package com.db2.edfu_pro.lecturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import controladores.ConexionSQLite;
import controladores.CuentaController;
import controladores.LecturaController;
import controladores.PersonaController;
import modelos.Cuenta;
import modelos.Lectura;
import modelos.Persona;
import modelos.Tarifa;

public class DetalleLecturaActivity extends AppCompatActivity {

    private TextView tv_clave, tv_contador, tv_direccion, tv_nombre, tv_lectura, tv_consumo, tv_fecha;
    private Tarifa tarifa;
    private Cuenta cuenta;
    private Persona persona;
    private Lectura lectura;
    private ConexionSQLite cnn;
    private int idcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lectura);

        cnn = new ConexionSQLite(this,"sigees_db",null,1);

        idcuenta = getIntent().getIntExtra("idcuenta",-1);

        detalle();
    }

    private void detalle(){
        LecturaController lc = new LecturaController(cnn);
        CuentaController cc = new CuentaController(cnn);
        PersonaController pc = new PersonaController(cnn);
        lectura = lc.read(idcuenta);
        cuenta = cc.read(idcuenta);
        persona = pc.read(cuenta.getIdpersona());

        tv_clave = (TextView) findViewById(R.id.tv_dt_clave);
        tv_contador = (TextView) findViewById(R.id.tv_dt_contador);
        tv_nombre = (TextView) findViewById(R.id.tv_dt_nombre);
        tv_direccion = (TextView) findViewById(R.id.tv_dt_direccion);
        tv_lectura = (TextView) findViewById(R.id.tv_dt_lectura);
        tv_fecha = (TextView) findViewById(R.id.tv_dt_fecha);
        tv_consumo = (TextView) findViewById(R.id.tv_dt_consumo);

        tv_clave.setText(cuenta.getClave());
        tv_contador.setText(cuenta.getNo_contador());
        tv_nombre.setText(persona.getNombre() + " " + persona.getApellido());
        tv_direccion.setText(cuenta.getDireccion());
        tv_lectura.setText(String.valueOf(lectura.getLectura_actual()));
        tv_fecha.setText(String.valueOf(lectura.getFecha_lectura()));
        tv_consumo.setText(String.valueOf(lectura.getEnergia_consumida()));
    }
}

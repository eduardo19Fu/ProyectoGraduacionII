package com.db2.edfu_pro.lecturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Date;

import controladores.ConexionSQLite;
import controladores.CuentaController;
import controladores.LecturaController;
import controladores.TarifaController;
import modelos.Cuenta;
import modelos.Lectura;
import modelos.Tarifa;

public class NormalActivity extends AppCompatActivity {

    private Tarifa tarifa;
    private Cuenta cuenta;
    private ConexionSQLite cnn;
    private TextView tv_clave,tv_contador,tv_direccion,tv_poste,tv_lec_ant;
    private EditText tx_lectura,tx_observaciones;
    private Button btn_guardar,btn_calcular;
    private int idcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        cnn = new ConexionSQLite(this,"sigees_db",null,1);

        idcuenta = getIntent().getIntExtra("idcuenta",-1);

        cargarCuenta();

        btn_calcular = (Button) findViewById(R.id.button_calcular);
        btn_guardar = (Button) findViewById(R.id.button_guardar_lect);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarConsumo();
            }
        });

    }

    private void cargarCuenta(){
        CuentaController cc = new CuentaController(cnn);
        cuenta = cc.read(idcuenta);

        tv_clave = (TextView) findViewById(R.id.txt_clave);
        tv_contador = (TextView) findViewById(R.id.txt_contador);
        tv_direccion = (TextView) findViewById(R.id.txt_direccion);
        tv_poste = (TextView) findViewById(R.id.txt_poste);
        tv_lec_ant = (TextView) findViewById(R.id.txt_lectura_anterior);

        tv_clave.setText(cuenta.getClave());
        tv_contador.setText(cuenta.getNo_contador());
        tv_direccion.setText(cuenta.getDireccion());
        tv_poste.setText(cuenta.getPoste());
        tv_lec_ant.setText(String.valueOf(cuenta.getLectura_acumulada()));

    }

    private void guardarConsumo(){
        TarifaController tc = new TarifaController(cnn);
        Lectura lectura = new Lectura();
        LecturaController lc = new LecturaController(cnn);
        tx_lectura = (EditText) findViewById(R.id.txt_lectura_act);

        int consumo = 0;
        int lect_ant = 0;
        int lect_act = 0;

        lect_ant = Integer.parseInt(tv_lec_ant.getText().toString());
        lect_act = Integer.parseInt(tx_lectura.getText().toString());

        consumo = lect_act - lect_ant;

        if(consumo <= 300){
            tarifa = tc.read("BTSS");
            if(tarifa != null){
                double valor_consumo = (consumo * tarifa.getValor());
                /*if(lc.maxid() == 0)
                    lectura.setIdregistro(1);
                else
                    lectura.setIdregistro(lc.maxid() + 1);*/
                lectura.setIdcuenta(idcuenta);
                lectura.setEnergia_consumida(consumo);
                lectura.setAlumbrado(tarifa.getAlumbrado_publico());
                lectura.setValor_consumo(valor_consumo);
                lectura.setTipo_tarifa(tarifa.getTipo_tarifa());
                lectura.setCargo_fijo(tarifa.getCargoFijo());
                lectura.setFecha_lectura(new Date());
                lectura.setUsuario_lectura(cuenta.getUsuario_lectura());
                lectura.setCargo_potencia_max(0.00);
                lectura.setCargo_potencia_contratada(0.00);

                double suma = valor_consumo + lectura.getCargo_fijo();
                double iva = suma * 0.12;
                double total = suma + iva + tarifa.getAlumbrado_publico();

                lectura.setIva(iva);
                lectura.setTotal(total);
                lectura.setLectura_anterior(lect_ant);
                lectura.setLectura_actual(lect_act);

                if(lc.create(lectura) > 0){
                    Toast.makeText(getBaseContext(),"Cargo realizado", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(),"No se realizo el cargo",Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}

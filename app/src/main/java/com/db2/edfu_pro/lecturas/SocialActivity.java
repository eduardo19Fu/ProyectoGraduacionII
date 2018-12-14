package com.db2.edfu_pro.lecturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

import controladores.ConexionSQLite;
import controladores.TarifaController;
import modelos.Tarifa;

public class SocialActivity extends AppCompatActivity {

    private ConexionSQLite conn;
    private Tarifa tarifa;
    private TarifaController tc;
    private EditText et_valor, et_cargo, et_ap;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        conn = new ConexionSQLite(this,"sigees_db",null,1);

        et_valor = (EditText) findViewById(R.id.txt_energia_s);
        et_cargo = (EditText) findViewById(R.id.txt_consumidor_s);
        et_ap = (EditText) findViewById(R.id.txt_apublico_s);
        btn1 = (Button) findViewById(R.id.btn_Guardar_s);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarTarifa();
            }
        });

    }

    private void registrarTarifa(){
        tc = new TarifaController(conn);
        tarifa = new Tarifa();

        tarifa.setIdtipo(1);
        tarifa.setTipo_tarifa("BTSS");
        tarifa.setValor_inicial(0);
        tarifa.setValor_final(300);
        tarifa.setValor(Double.parseDouble(et_valor.getText().toString()));
        tarifa.setCargoFijo(Double.parseDouble(et_cargo.getText().toString()));
        tarifa.setCargo_potencia_contratada(0);
        tarifa.setCargo_potencia_maxima(0);
        tarifa.setAlumbrado_publico(Double.parseDouble(et_ap.getText().toString()));

        long rs = tc.create(tarifa);
        if(rs > 0){
            Toast.makeText(this,"Registro de Tarifa Social realizado.", Toast.LENGTH_LONG).show();
            et_valor.setText("");
            et_cargo.setText("");
            et_ap.setText("");
        }else{
            Toast.makeText(this,"Registro de Tarifa Social no realizado.", Toast.LENGTH_LONG).show();
        }
    }
}

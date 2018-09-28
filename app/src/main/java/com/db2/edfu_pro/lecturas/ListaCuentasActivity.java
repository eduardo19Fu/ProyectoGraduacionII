package com.db2.edfu_pro.lecturas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import controladores.ConexionSQLite;
import controladores.CuentaController;
import modelos.Cuenta;

public class ListaCuentasActivity extends AppCompatActivity {

    private ListView lv_cuentas;
    private List<Cuenta> listaCuentas;
    private List<String> listaInformacion;
    private ConexionSQLite cnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cuentas);

        cnn = new ConexionSQLite(getApplicationContext(), "sigees_db",null,1);

        lv_cuentas = (ListView) findViewById(R.id.lista_cuentas);

        consultarCuentas();

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.);

    }

    private void consultarCuentas() {
        CuentaController cc = new CuentaController(cnn);

        listaCuentas = cc.read();

        for(int i = 0; i < listaCuentas.size(); i++){
            listaInformacion.add(listaCuentas.get(i).getNo_contador() + " - " + listaCuentas.get(i).getClave());
        }

    }
}

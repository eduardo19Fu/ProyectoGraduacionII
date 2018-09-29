package com.db2.edfu_pro.lecturas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
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

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        lv_cuentas.setAdapter(adapter);

        lv_cuentas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clave = listaCuentas.get(i).getClave();
                if(!listaCuentas.get(i).getTipo_servicio().equals("DEMANDA")) {
                    Log.i("valor",listaCuentas.get(i).getTipo_servicio());
                    Intent intent = new Intent(getApplicationContext(),NormalActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Es de demanda", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void consultarCuentas() {
        CuentaController cc = new CuentaController(cnn);

        listaInformacion = new ArrayList<>();

        listaCuentas = cc.read();

        for(int i = 0; i < listaCuentas.size(); i++){
            listaInformacion.add(listaCuentas.get(i).getNo_contador() + "\n" + listaCuentas.get(i).getClave());
        }
    }
}

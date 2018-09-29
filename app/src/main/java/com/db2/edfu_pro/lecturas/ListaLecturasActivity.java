package com.db2.edfu_pro.lecturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import controladores.ConexionSQLite;
import controladores.CuentaController;
import controladores.LecturaController;
import modelos.Cuenta;
import modelos.Lectura;

public class ListaLecturasActivity extends AppCompatActivity {

    private ConexionSQLite cnn;
    private ListView lv_lecturas;
    private List<Lectura> listaLecturas;
    private List<String> listaShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lecturas);

        cnn = new ConexionSQLite(this,"sigees_db",null,1);

        lv_lecturas = (ListView) findViewById(R.id.lista_lecturas);

        cargarLecturas();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaShow);
        lv_lecturas.setAdapter(adapter);
    }

    private void cargarLecturas(){
        LecturaController lc = new LecturaController(cnn);
        listaLecturas = lc.read();
        listaShow = new ArrayList<>();
        Cuenta cuenta;
        CuentaController cc = new CuentaController(cnn);

        for(int i = 0; i < listaLecturas.size(); i++){
            cuenta = cc.read(listaLecturas.get(i).getIdcuenta());

            listaShow.add(cuenta.getNo_contador() + "\n" + cuenta.getClave() + "\n" + listaLecturas.get(i).getLectura_actual());

        }
    }
}

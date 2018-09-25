package com.db2.edfu_pro.lecturas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import controladores.ConexionSQLite;
import controladores.CuentaController;
import interfaces.CuentaService;
import modelos.Cuenta;
import modelos.Peticion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SolicitudCuentasActivity extends AppCompatActivity {

    private ConexionSQLite conn;
    private EditText et_lector, et_dia;
    private Button btn1;
    private final String baseUrl = "http://192.168.43.88:3030/";
    private List<Cuenta> cuentas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_cuentas);

        conn = new ConexionSQLite(this,"sigees_db",null,1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final CuentaService cuentaService = retrofit.create(CuentaService.class);

        et_lector = (EditText) findViewById(R.id.txt_lector);
        et_dia = (EditText) findViewById(R.id.txt_dia);
        btn1 = (Button) findViewById(R.id.btn_enviar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lector = et_lector.getText().toString().trim();
                String dia = et_dia.getText().toString().trim();

                if(!lector.isEmpty() && !dia.isEmpty()){
                    Peticion peticion = new Peticion(Integer.parseInt(dia),lector);
                    Call<List<Cuenta>> lista = cuentaService.savePost(peticion);
                    lista.enqueue(new Callback<List<Cuenta>>() {
                        @Override
                        public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                            if(response.isSuccessful()){
                                cuentas = response.body();
                                CuentaController cuenta = new CuentaController(conn);
                                if(cuenta.create(cuentas) > 0){
                                    Toast.makeText(getBaseContext(),"cuentas agregadas con exito",Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getBaseContext(),"cuentas no pudieron ser agregadas con exito",Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getBaseContext(),"conexion fallo",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Cuenta>> call, Throwable t) {
                            Toast.makeText(getBaseContext(),"petición fallo",Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getBaseContext(),"Rellene todos los campos.", Toast.LENGTH_LONG);
                }
            }
        });


    }
}

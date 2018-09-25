package com.db2.edfu_pro.lecturas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controladores.ConexionSQLite;
import controladores.UsuarioController;
import modelos.Usuario;


public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private UsuarioController usuario_controller;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLite conn = new ConexionSQLite(this,"sigees_db",null,1);
        Button ingreso = (Button) findViewById(R.id.btn_ingreso);
        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1 = (EditText) findViewById(R.id.txt_usuario);
                et2 = (EditText) findViewById(R.id.txt_password);
                usuario_controller = new UsuarioController();
                usuario = new Usuario();
                usuario.setUsuario(et1.getText().toString());
                usuario.setPassword(et2.getText().toString());

                if(usuario_controller.hacerLogin(usuario)){
                    Intent nuevoView = new Intent(MainActivity.this,PrincipalJefeActivity.class);
                    nuevoView.putExtra("usuario",usuario.getUsuario());
                    startActivity(nuevoView);
                }else
                    Toast.makeText(getApplicationContext(),"no realizado",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.db2.edfu_pro.lecturas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import controladores.ConexionSQLite;
import controladores.LecturaController;
import modelos.Lectura;
import utilidades.SaveAsyncTask;


public class OpcionesLecturaFragment extends Fragment {

    private Button btn_consultar,btn_sincronizar;
    private List<Lectura> lista;
    private Lectura lecturas;
    private ConexionSQLite cnn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_opciones_lectura, container, false);
        cnn = new ConexionSQLite(getActivity().getApplicationContext(), "sigees_db",null,1);

        btn_consultar = (Button) view.findViewById(R.id.button_consultar);
        btn_sincronizar = (Button) view.findViewById(R.id.button_sincro);

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListaLecturasActivity.class);
                startActivity(intent);
            }
        });

        btn_sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(consultarLecturas()){
                    Toast.makeText(getActivity().getApplicationContext(),"Registros sincronizados con éxito",Toast.LENGTH_LONG);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"No fue posible realizar la sincronización de forma correcta",Toast.LENGTH_LONG);
                }
            }
        });

        return view;
    }

    private boolean consultarLecturas(){
        lista = new ArrayList<>();
        LecturaController lc = new LecturaController(cnn);
        SaveAsyncTask tsk;

        if(lc.read() == null) {
            Toast.makeText(getActivity().getApplicationContext(),"No hay lecturas que sincronizar", Toast.LENGTH_LONG);
            return false;
        }else{
            lista = lc.read();
            for(int i = 0; i < lista.size(); i++){
                lecturas = new Lectura();
                lecturas.setIdregistro(lista.get(i).getIdregistro());
                lecturas.setIdcuenta(lista.get(i).getIdcuenta());
                lecturas.setEnergia_consumida(lista.get(i).getEnergia_consumida());
                lecturas.setAlumbrado(lista.get(i).getAlumbrado());
                lecturas.setValor_consumo(lista.get(i).getValor_consumo());
                lecturas.setTipo_tarifa(lista.get(i).getTipo_tarifa());
                lecturas.setTotal(lista.get(i).getTotal());
                lecturas.setCargo_fijo(lista.get(i).getCargo_fijo());
                lecturas.setFecha_lectura(lista.get(i).getFecha_lectura());
                lecturas.setIva(lista.get(i).getIva());
                lecturas.setUsuario_lectura(lista.get(i).getUsuario_lectura());
                lecturas.setCargo_potencia_max(lista.get(i).getCargo_potencia_max());
                lecturas.setCargo_potencia_contratada(lista.get(i).getCargo_potencia_contratada());
                lecturas.setLectura_anterior(lista.get(i).getLectura_anterior());
                lecturas.setLectura_actual(lista.get(i).getLectura_actual());

                tsk = new SaveAsyncTask();
                tsk.execute(lecturas);
            }
            return true;
        }

    }
}

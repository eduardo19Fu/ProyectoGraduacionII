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


public class OpcionesLecturaFragment extends Fragment {

    private Button btn_consultar,btn_sincronizar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_opciones_lectura, container, false);

        btn_consultar = (Button) view.findViewById(R.id.button_consultar);
        btn_sincronizar = (Button) view.findViewById(R.id.button_sincro);

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListaLecturasActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

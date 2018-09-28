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


public class CuentasFragment extends Fragment {

    private Button btn1;
    private Button btn2;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_cuentas, container, false);
        btn1 = (Button) view.findViewById(R.id.btn_solicitar);
        btn2 = (Button) view.findViewById(R.id.btn_listar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SolicitudCuentasActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListaCuentasActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}

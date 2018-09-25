package com.db2.edfu_pro.lecturas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TarifasFragment extends Fragment {

    private Button btn_social, btn_no_social, btn_btdfp, btn_btdp;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tarifas, container, false);

        btn_social = (Button) view.findViewById(R.id.btn_social);
        btn_no_social = (Button) view.findViewById(R.id.btn_no_social);
        btn_btdfp = (Button) view.findViewById(R.id.btn_fuera_punta);
        btn_btdp = (Button) view.findViewById(R.id.btn_punta);

        btn_social.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SocialActivity.class);
                startActivity(intent);
            }
        });

        btn_no_social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoSocialActivity.class);
                startActivity(intent);
            }
        });

        btn_btdfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DemandaFueraActivity.class);
                startActivity(intent);
            }
        });

        btn_btdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DemandaActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

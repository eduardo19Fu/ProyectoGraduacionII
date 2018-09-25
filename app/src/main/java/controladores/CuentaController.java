package controladores;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import modelos.Cuenta;

public class CuentaController {

    ConexionSQLite conexion;

    public CuentaController(ConexionSQLite cnn){
        conexion = cnn;
    }

    public long create(List<Cuenta> cuentas){
        SQLiteDatabase BaseDatos = conexion.getWritableDatabase();

        ContentValues registro = new ContentValues();
        long rs = 0;
        for(int i = 0; i < cuentas.size(); i++){
            registro.put("idcuenta",cuentas.get(i).getIdcuenta());
            Log.i("cuenta",String.valueOf(cuentas.get(i).getIdcuenta()));
            registro.put("clave",cuentas.get(i).getClave());
            registro.put("no_contador",cuentas.get(i).getNo_contador());
            registro.put("direccion",cuentas.get(i).getDireccion());
            registro.put("idbarrio",cuentas.get(i).getIdbarrio());
            registro.put("orden_lectura",cuentas.get(i).getOrden_lectura());
            registro.put("marchamo",cuentas.get(i).getMarchamo());
            registro.put("tipo_servicio",cuentas.get(i).getTipo_servicio());
            registro.put("idpersona",cuentas.get(i).getIdpersona());
            registro.put("voltios_solicitados",cuentas.get(i).getVoltios_solicitados());
            registro.put("lectura_acumulada",cuentas.get(i).getLectura_acumulada());
            registro.put("estado",cuentas.get(i).getEstado());
            registro.put("zona",cuentas.get(i).getZona());
            registro.put("dia_visita",cuentas.get(i).getDia_visita());
            registro.put("referencia",cuentas.get(i).getReferecia());
            registro.put("usuario_lectura",cuentas.get(i).getUsuario_lectura());
            registro.put("fecha_siguiente_visita",String.valueOf(cuentas.get(i).getFecha_siguiente_visita()));
            registro.put("potencia_contratada",cuentas.get(i).getPotencia_contratada());
            registro.put("poste",cuentas.get(i).getPoste());
            registro.put("latitud",cuentas.get(i).getLatitud());
            registro.put("longitud",cuentas.get(i).getLongitud());

            rs = BaseDatos.insert("cuenta",null, registro);
        }

        BaseDatos.close();
        return rs;
    }
}

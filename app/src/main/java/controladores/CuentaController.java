package controladores;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Cuenta;
import utilidades.Utilidades;

public class CuentaController {

    private Cuenta cuenta;

    ConexionSQLite conexion;


    public CuentaController(ConexionSQLite cnn){
        conexion = cnn;
    }

    public long create(List<Cuenta> cuentas){
        SQLiteDatabase BaseDatos = conexion.getWritableDatabase();

        long rs = 0;
        for(int i = 0; i < cuentas.size(); i++){
            ContentValues registro = new ContentValues();
            registro.put("idcuenta",cuentas.get(i).getIdcuenta());
            //Log.i("cuenta",String.valueOf(cuentas.get(i).getIdcuenta()));
            registro.put("clave",cuentas.get(i).getClave());
            registro.put("no_contador",cuentas.get(i).getNo_contador());
            registro.put("direccion",cuentas.get(i).getDireccion());
            registro.put("idbarrio",cuentas.get(i).getIdbarrio());
            registro.put("orden_lectura",String.valueOf(cuentas.get(i).getOrden_lectura()));
            registro.put("marchamo",cuentas.get(i).getMarchamo());
            registro.put("tipo_servicio",cuentas.get(i).getTipo_servicio());
            registro.put("idpersona",cuentas.get(i).getIdpersona());
            registro.put("voltios_solicitados",String.valueOf(cuentas.get(i).getVoltios_solicitados()));
            registro.put("lectura_acumulada",String.valueOf(cuentas.get(i).getLectura_acumulada()));
            registro.put("estado",cuentas.get(i).getEstado());
            registro.put("zona",cuentas.get(i).getZona());
            registro.put("dia_visita",cuentas.get(i).getDia_visita());
            registro.put("referencia",cuentas.get(i).getReferecia());
            registro.put("usuario_lectura",cuentas.get(i).getUsuario_lectura());
            registro.put("fecha_siguiente_visita",cuentas.get(i).getFecha_siguiente_visita().getTime());
            registro.put("potencia_contratada",cuentas.get(i).getPotencia_contratada());
            registro.put("poste",cuentas.get(i).getPoste());
            registro.put("latitud",cuentas.get(i).getLatitud());
            registro.put("longitud",cuentas.get(i).getLongitud());

            rs = BaseDatos.insert("cuenta",null, registro);
        }

        BaseDatos.close();
        return rs;
    }

    public List<Cuenta> read(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        List<Cuenta> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + Utilidades.TABLA_CUENTA, null);

        while(cursor.moveToNext()){
            cuenta = new Cuenta();
            cuenta.setIdcuenta(cursor.getInt(0));
            cuenta.setClave(cursor.getString(1));
            cuenta.setNo_contador(cursor.getString(2));
            cuenta.setDireccion(cursor.getString(3));
            cuenta.setOrden_lectura(cursor.getInt(4));
            cuenta.setMarchamo(cursor.getString(5));
            cuenta.setTipo_servicio(cursor.getString(6));
            cuenta.setIdpersona(cursor.getInt(7));
            cuenta.setVoltios_solicitados(cursor.getInt(8));
            cuenta.setLectura_acumulada(cursor.getInt(9));
            cuenta.setEstado(cursor.getString(10));
            cuenta.setZona(cursor.getString(11));
            cuenta.setDia_visita(cursor.getInt(12));
            cuenta.setReferecia(cursor.getString(13));
            cuenta.setUsuario_lectura(cursor.getString(14));
            cuenta.setFecha_siguiente_visita(new Date(cursor.getLong(15)));
            cuenta.setPotencia_contratada(cursor.getInt(16));
            cuenta.setPoste(cursor.getString(17));
            cuenta.setLatitud(cursor.getString(18));
            cuenta.setLongitud(cursor.getString(19));

            lista.add(cuenta);
        }
        db.close();
        return lista;
    }
}

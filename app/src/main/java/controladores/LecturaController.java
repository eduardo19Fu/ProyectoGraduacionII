package controladores;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Lectura;
import okhttp3.internal.Util;
import utilidades.Utilidades;

public class LecturaController {

    private ConexionSQLite conexion;
    private Lectura lectura;

    public LecturaController(ConexionSQLite cnn) {
        conexion = cnn;
    }

    public long create(Lectura lectura){
        SQLiteDatabase db = conexion.getWritableDatabase();

        long rs = 0;

        ContentValues registro = new ContentValues();
        registro.put(Utilidades.ID_CUENTA2,lectura.getIdcuenta());
        registro.put(Utilidades.ENERGIA_CONSUMIDA,lectura.getEnergia_consumida());
        registro.put(Utilidades.CARGO_CONSUMO,lectura.getValor_consumo());
        registro.put(Utilidades.CARGO_ALUMBRADO,lectura.getAlumbrado());
        registro.put(Utilidades.CARGO_IVA,lectura.getIva());
        registro.put(Utilidades.CARGO_POTENCIA_MAXIMA,lectura.getCargo_potencia_max());
        registro.put(Utilidades.CARGO_POTENCIA_CONTRATADA,lectura.getCargo_potencia_contratada());
        registro.put(Utilidades.TIPO_TARIFA, lectura.getTipo_tarifa());
        registro.put(Utilidades.USUARIO_LECTURA, lectura.getUsuario_lectura());
        registro.put(Utilidades.TOTAL,lectura.getTotal());
        registro.put(Utilidades.FECHA_LECTURA,lectura.getFecha_lectura().getTime());
        registro.put(Utilidades.LECTURA_ANT, lectura.getLectura_anterior());
        registro.put(Utilidades.LECTURA_ACT, lectura.getLectura_actual());

        rs = db.insert("lectura",null,registro);
        db.close();
        return rs;
    }

    public List<Lectura> read(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from lectura",null);
        List<Lectura> lista = new ArrayList<>();

        while(cursor.moveToNext()){
            lectura = new Lectura();
            lectura.setIdregistro(cursor.getInt(0));
            lectura.setIdcuenta(cursor.getInt(1));
            lectura.setEnergia_consumida(cursor.getInt(2));
            lectura.setValor_consumo(cursor.getDouble(3));
            lectura.setCargo_fijo(cursor.getDouble(4));
            lectura.setAlumbrado(cursor.getDouble(5));
            lectura.setIva(cursor.getDouble(6));
            lectura.setCargo_potencia_max(cursor.getDouble(7));
            lectura.setCargo_potencia_contratada(cursor.getDouble(8));
            lectura.setTipo_tarifa(cursor.getString(9));
            lectura.setUsuario_lectura(cursor.getString(10));
            lectura.setTotal(cursor.getDouble(11));
            lectura.setFecha_lectura(new Date(cursor.getLong(12)));
            lectura.setLectura_anterior(cursor.getInt(13));
            lectura.setLectura_actual(cursor.getInt(14));

            lista.add(lectura);
        }

        db.close();
        return lista;

    }
}

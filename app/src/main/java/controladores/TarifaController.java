package controladores;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import modelos.Tarifa;
import utilidades.Utilidades;

public class TarifaController {

    ConexionSQLite conexion;
    Tarifa tarifa;

    public TarifaController(ConexionSQLite cnn){
        conexion = cnn;
    }

    public long create(Tarifa tarifa){
        SQLiteDatabase BaseDatos = conexion.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Utilidades.ID_TIPO,String.valueOf(tarifa.getIdtipo()));
        registro.put(Utilidades.TIPO_TARIFA,tarifa.getTipo_tarifa());
        registro.put(Utilidades.VALOR_INI,String.valueOf(tarifa.getValor_inicial()));
        registro.put(Utilidades.VALOR_FIN,String.valueOf(tarifa.getValor_final()));
        registro.put(Utilidades.VALOR,String.valueOf(tarifa.getValor()));
        registro.put(Utilidades.CARGO_FIJO, tarifa.getCargoFijo());
        registro.put(Utilidades.POTENCIA_CON,tarifa.getCargo_potencia_contratada());
        registro.put(Utilidades.POTENCIA_MAX,tarifa.getCargo_potencia_maxima());

        long rs = BaseDatos.insert("tarifa",null,registro);

        BaseDatos.close();

        return rs;
    }

    private void read(){

    }

    public Tarifa read(String tipo){
        tarifa = new Tarifa();
        SQLiteDatabase db = conexion.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + Utilidades.TABLA_TARIFA + " where " + Utilidades.TIPO + " = ?",new String[] {tipo});
        cursor.moveToNext();
        tarifa.setIdtipo(cursor.getInt(0));
        tarifa.setTipo_tarifa(cursor.getString(1));
        tarifa.setValor_inicial(cursor.getInt(2));
        tarifa.setValor_final(cursor.getInt(3));
        tarifa.setValor(cursor.getDouble(4));
        tarifa.setCargoFijo(cursor.getDouble(5));
        tarifa.setCargo_potencia_maxima(cursor.getDouble(6));
        tarifa.setCargo_potencia_contratada(cursor.getDouble(7));
        tarifa.setAlumbrado_publico(cursor.getDouble(8));

        db.close();
        return tarifa;
    }

    private void update(){

    }

    private void delete(){

    }
}

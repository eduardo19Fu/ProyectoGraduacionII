package controladores;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import modelos.Tarifa;

public class TarifaController {

    ConexionSQLite conexion;

    public TarifaController(ConexionSQLite cnn){
        conexion = cnn;
    }

    public long create(Tarifa tarifa){
        SQLiteDatabase BaseDatos = conexion.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("idtipo",String.valueOf(tarifa.getIdtipo()));
        registro.put("tipo_tarifa",tarifa.getTipo_tarifa());
        registro.put("valor_inicial",String.valueOf(tarifa.getValor_inicial()));
        registro.put("valor_final",String.valueOf(tarifa.getValor_final()));
        registro.put("valor",String.valueOf(tarifa.getValor()));

        long rs = BaseDatos.insert("tarifa",null,registro);

        BaseDatos.close();

        return rs;
    }

    private void read(){

    }

    private void update(){

    }

    private void delete(){

    }
}

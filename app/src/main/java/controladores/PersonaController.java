package controladores;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import modelos.Persona;

public class PersonaController {

    ConexionSQLite conexion;

    public PersonaController(ConexionSQLite conexion) {
        this.conexion = conexion;
    }

    public long create(List<Persona> lista){
        SQLiteDatabase db = conexion.getWritableDatabase();

        long rs = 0;
        for(int i = 0; i < lista.size(); i++){

        }
        return 0;
    }
}

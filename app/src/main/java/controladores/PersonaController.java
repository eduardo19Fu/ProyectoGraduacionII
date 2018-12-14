package controladores;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;
import java.util.List;

import modelos.Persona;

public class PersonaController {

    private Persona persona;

    ConexionSQLite conexion;

    public PersonaController(ConexionSQLite conexion) {
        this.conexion = conexion;
    }

    public long create(List<Persona> lista){
        SQLiteDatabase db = conexion.getWritableDatabase();

        long rs = 0;
        for(int i = 0; i < lista.size(); i++){
            ContentValues registro = new ContentValues();
            registro.put("idpersona",lista.get(i).getIdpersona());
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("apellido",lista.get(i).getApellido());
            if(lista.get(i).getFecha_creacion() != null)
                registro.put("fecha_creacion",lista.get(i).getFecha_creacion().getTime());
            else
                registro.put("fecha_creacion",new Date().getTime());
            registro.put("nit",lista.get(i).getNit());
            registro.put("identificacion",lista.get(i).getIdentificacion());
            registro.put("tipo_identificacion",lista.get(i).getTipo_identificacion());
            registro.put("correo_electronico",lista.get(i).getCorreo_electronico());
            registro.put("telefono",lista.get(i).getTelefono());

            rs = db.insert("persona",null,registro);
        }
        db.close();
        return rs;
    }

    public Persona read(int idpersona){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from persona where idpersona = ?", new String[] {String.valueOf(idpersona)});
        cursor.moveToNext();

        persona = new Persona();
        persona.setIdpersona(cursor.getInt(0));
        persona.setNombre(cursor.getString(1));
        persona.setApellido(cursor.getString(2));
        persona.setFecha_creacion(new Date(cursor.getLong(3)));
        persona.setNit(cursor.getString(4));
        persona.setIdentificacion(cursor.getString(5));
        persona.setTipo_identificacion(cursor.getString(6));
        persona.setCorreo_electronico(cursor.getString(7));
        persona.setTelefono(cursor.getString(8));

        return persona;
    }

}

package controladores;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;
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

}

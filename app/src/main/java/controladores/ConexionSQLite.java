package controladores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utilidades.Utilidades;

public class ConexionSQLite extends SQLiteOpenHelper{



    public ConexionSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sigees) {
        sigees.execSQL(Utilidades.CREAR_TABLA_TARIFA);
        sigees.execSQL(Utilidades.CREAR_TABLA_CUENTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sigees, int versionAntigua, int versionNueva) {
        sigees.execSQL("DROP TABLE IF EXISTS tarifa");
        sigees.execSQL("DROP TABLE IF EXISTS cuenta");
        onCreate(sigees);
    }
}

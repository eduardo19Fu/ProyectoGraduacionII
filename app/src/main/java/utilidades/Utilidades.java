package utilidades;

import java.security.PublicKey;

public class Utilidades {

    // Constates campos de tabla Tarifas
    public static final String TABLA_TARIFA = "tarifa";
    public static final String ID_TIPO = "idtipo";
    public static final String TIPO = "tipo_tarifa";
    public static final String VALOR_INI = "valor_inicial";
    public static final String VALOR_FIN = "valor_final";
    public static final String VALOR = "valor";
    public static final String CARGO_FIJO = "cargo_fijo";
    public static final String POTENCIA_CON = "cargo_potencia_contratada";
    public static final String POTENCIA_MAX = "cargo_potencia_maxima";
    public static final String ALUMBRADO_PUB = "alumbrado_publico";

    public static final String CREAR_TABLA_TARIFA = "CREATE TABLE "+ TABLA_TARIFA +"("+ID_TIPO+" INTEGER, "+TIPO+" TEXT,"+VALOR_INI+" INTEGER," +
            " "+VALOR_FIN+" INTEGER, "+VALOR+" DOUBLE, "+CARGO_FIJO+" DOUBLE, "+POTENCIA_CON+" DOUBLE,"+POTENCIA_MAX+" DOUBLE, "+ALUMBRADO_PUB+" DOUBLE)";

    // Constantes campos de tabla Lectura

    // Constantes campos de tabla Cuentas

    public static final String TABLA_CUENTA = "cuenta";
    public static final String ID_CUENTA = "idcuenta";
    public static final String CLAVE = "clave";
    public static final String NO_CONTADOR = "no_contador";
    public static final String DIRECCION = "direccion";
    public static final String BARRIO = "idbarrio";
    public static final String ORDEN = "orden_lectura";
    public static final String MARCHAMO = "marchamo";
    public static final String TIPO_SERVICIO = "tipo_servicio";
    public static final String PERSONA = "idpersona";
    public static final String VOLTAJE = "voltios";
    public static final String LEC_ACUMULADA = "lectura_acumulada";
    public static final String ESTADO = "estado";
    public static final String ZONA = "zona";
    public static final String DIA = "dia_visita";
    public static final String REF = "referencia";
    public static final String USUARIO = "usuario_lectura";
    public static final String FECHA = "fecha_siguiente_visita";
    public static final String POTENCIA_CONTRATADA = "potencia_contratada";
    public static final String POSTE = "poste";
    public static final String LATITUD = "latitud";
    public static final String LONGITUD = "longitud";

    public static final String CREAR_TABLA_CUENTA = "CREATE TABLE "+ TABLA_CUENTA +"("+ID_CUENTA+" INTEGER PRIMARY KEY, "+CLAVE+" TEXT,"+NO_CONTADOR+" TEXT," +
            " "+DIRECCION+" TEXT, "+BARRIO+" INTEGER, "+ORDEN+" INTEGER, "+MARCHAMO+" TEXT,"+TIPO_SERVICIO+" TEXT, "+PERSONA+" INTEGER, "+VOLTAJE+" INTEGER," +
            " "+LEC_ACUMULADA+" INTEGER, "+ESTADO+" TEXT, "+ZONA+" TEXT, "+DIA+" INTEGER, "+REF+" TEXT,"+USUARIO+" TEXT,"+FECHA+" DATE,"+POTENCIA_CONTRATADA+" INTEGER," +
            " "+POSTE+" TEXT, "+LATITUD+" TEXT, "+LONGITUD+" TEXT)";

    // Constantes campos de tabla Persona
}

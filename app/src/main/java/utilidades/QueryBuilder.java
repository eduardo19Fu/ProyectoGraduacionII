package utilidades;

import java.text.SimpleDateFormat;
import java.util.List;

import modelos.Lectura;

public class QueryBuilder {

    // Return el nombre de la base de datos creada en nuestra cuenta
    // de mlab.com
    public String getDatabaseName(){
        return "lecturas";
    }

    // Return el codigo del API de tu cuenta en mlab
    public String getApiKey(){
        return "lNxButA1IC9RdjAA4I5IL42iTYTmQBzW";
    }

    // Construye el URL que te permite manejar tu base de datos,
    // collections y documentos.
    public String getBaseUrl(){
        return "https://api.mlab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    // Completa el formato de tu URL y la agrega a tu API Key al final
    public String docApiKeyUrl(){
        return "?apiKey=" + getApiKey();
    }

    public String documentRequest(){
        return "cargos";
    }

    public String buildContactsSaveURL(){
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }

    public String createList(Lectura lectura){
        return String.format("{" +
                        "\"idregistro\" : \"%s\", " +
                        "\"idcuenta\": \"%s\", " +
                        "\"energia_consumida\": \"%s\", " +
                        "\"alumbrado\": \"%s\" ," +
                        "\"valor_consumo\" : \"%s\", " +
                        "\"tipo_tarifa\" : \"%s\" , " +
                        "\"total\" : \"%s\", " +
                        "\"cargo_fijo\" : \"%s\"," +
                        "\"fecha_lectura\" : \"%s\", " +
                        "\"iva\" : \"%s\", " +
                        "\"usuario_lectura\" : \"%s\"," +
                        "\"cargo_potencia_max\" : \"%s\", " +
                        "\"cargo_potencia_contratada\" : \"%s\", " +
                        "\"lectura_anterior\" : \"%s\", " +
                        "\"lectura_actual\" : \"%s\"" +
                        "}",
                String.valueOf(lectura.getIdregistro()),
                String.valueOf(lectura.getIdcuenta()),
                String.valueOf(lectura.getEnergia_consumida()),
                String.valueOf(lectura.getAlumbrado()),
                String.valueOf(lectura.getValor_consumo()),
                lectura.getTipo_tarifa(),
                String.valueOf(lectura.getTotal()),
                String.valueOf(lectura.getCargo_fijo()),
                new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(lectura.getFecha_lectura()),
                String.valueOf(lectura.getIva()),
                lectura.getUsuario_lectura(),
                String.valueOf(lectura.getCargo_potencia_max()),
                String.valueOf(lectura.getCargo_potencia_contratada()),
                String.valueOf(lectura.getLectura_anterior()),
                String.valueOf(lectura.getLectura_actual())
                );
    }
}

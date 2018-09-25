package interfaces;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

import java.util.List;

import modelos.Cuenta;
import modelos.Peticion;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentaService {

    @POST("/cuenta")
    @FormUrlEncoded
    Call<List<Cuenta>> savePost(@Field("dia_visita") int dia_visita, @Field("usuario_lectura") String usuario_lectura);
}

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
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CuentaService {


    @GET("/cuenta")
    Call<List<Cuenta>> getCuentas(@Query("usuario_lectura") String lector, @Query("dia") int dia);
}

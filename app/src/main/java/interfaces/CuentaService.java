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

public interface CuentaService {

    @Headers("Content-Type: application/json")
    @POST("/cuenta")
    Call<List<Cuenta>> savePost(@Body Peticion peticion);
}

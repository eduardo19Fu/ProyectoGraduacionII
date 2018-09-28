package interfaces;


import java.util.List;

import modelos.Cuenta;
import modelos.Persona;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CuentaService {


    @GET("/cuenta")
    Call<List<Cuenta>> getCuentas(@Query("usuario_lectura") String lector, @Query("dia") int dia);

    @GET("/persona")
    Call<List<Persona>> getPersonas(@Query("usuario_lectura") String lector, @Query("dia") int dia);

}

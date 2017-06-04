package com.example.suarezpc.datosabiertosws.datosApi;

import com.example.suarezpc.datosabiertosws.models.Lengua;
import com.example.suarezpc.datosabiertosws.models.Desmovilizados;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by suarezpc on 22/05/17.
 */

public interface DatosOpenApiService {

    @GET("y5wk-q9yj.json")
    Call<ArrayList<Lengua>> obtenerLengua();

    @GET("mwp8-2e27.json")
    Call<List<Desmovilizados>> obtenerDesmovilizados();




}

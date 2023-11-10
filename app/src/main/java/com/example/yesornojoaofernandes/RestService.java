package com.example.yesornojoaofernandes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestService {

    @GET(".")
    Call<Resposta> consultar();
}

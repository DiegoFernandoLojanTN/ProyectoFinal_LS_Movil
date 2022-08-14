package com.example.tickets.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventosAPi {

    @GET("api/eventos/")
    public Call<List<Eventos>> find();

    @GET("api/orders/")
    public Call<List<Eventos>> orden();
}

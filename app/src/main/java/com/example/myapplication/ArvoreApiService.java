package com.example.myapplication;
import com.example.myapplication.Arvore;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArvoreApiService {

    // Interface para interagir com a API
    @GET("trees") // endpoint para obter as árvores
    Call<List<Arvore>> getArvores(); // Chama o método para obter uma lista de árvores
}
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaArvoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_arvores);  // Define o layout da activity

        // Configurar o RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://arborizacao-urbana-pe.vercel.app/") // URL base da sua API
                .addConverterFactory(GsonConverterFactory.create()) // Converte JSON para objetos
                .build();

        ArvoreApiService apiService = retrofit.create(ArvoreApiService.class);

        // Chamada para obter as árvores
        Call<List<Arvore>> call = apiService.getArvores();

        call.enqueue(new Callback<List<Arvore>>() {
            @Override
            public void onResponse(Call<List<Arvore>> call, Response<List<Arvore>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Arvore> listaArvores = response.body();
                    // Configurar o RecyclerView com os dados da resposta
                    ArvoreAdapter adapter = new ArvoreAdapter(listaArvores);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Arvore>> call, Throwable t) {
                // Lidar com falha, por exemplo, mostrando uma mensagem de erro
            }
        });

        // Configurar o botão para voltar à tela inicial
        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Finaliza a atividade atual e volta à tela inicial
            }
        });
    }
}
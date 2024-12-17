package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botão para navegar para a ListaArvoresActivity
        Button btnCarregarArvores = findViewById(R.id.btnCarregarArvores);
        btnCarregarArvores.setOnClickListener(v -> {
            // Iniciar a ListaArvoresActivity
            Intent intent = new Intent(MainActivity.this, ListaArvoresActivity.class);
            startActivity(intent);
        });
    }
}
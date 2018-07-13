package com.github.frequencianomes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import models.nomesFrequentes;
import service.ibge_service;

public class freqNomesActivity extends AppCompatActivity {

    Spinner spn_generos;
    Button btn_buscar_nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freq_nomes);

        spn_generos = findViewById(R.id.spn_generos);
        btn_buscar_nomes = findViewById(R.id.btn_buscar_nomes);
    }

    public void buscar(View view) {
        try {
            nomesFrequentes retorno = new ibge_service(spn_generos.getSelectedItem().toString()).execute().get();
            Intent intent = new Intent(freqNomesActivity.this, ResultadosActivity.class);
            intent.putExtra("dadosAPI", retorno);
            startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

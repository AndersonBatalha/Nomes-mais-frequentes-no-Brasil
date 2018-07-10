package com.github.frequencianomes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;

import models.rankingNomes;
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

        btn_buscar_nomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONArray retorno = new ibge_service(spn_generos.getSelectedItem().toString()).execute().get();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

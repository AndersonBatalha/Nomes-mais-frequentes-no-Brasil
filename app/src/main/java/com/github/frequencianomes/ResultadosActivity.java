package com.github.frequencianomes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import models.*;

public class ResultadosActivity extends AppCompatActivity {

    ListView lst_ranking;

    nomesFrequentes ranking;
    itemRankingNomes item;
    JSONObject item_array_json;
    JSONArray array_dados_json;
    ArrayList<String> dadosNomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        lst_ranking = findViewById(R.id.lst_ranking);

        dadosNomes = new ArrayList<>();

        Intent intent = this.getIntent();
        this.ranking = (nomesFrequentes) intent.getSerializableExtra("dadosAPI");
        array_dados_json = new JSONArray(this.ranking.getRes());

        for (int i = 0; i < array_dados_json.length(); i++) {
            try {
                item_array_json = (JSONObject) array_dados_json.get(i);
                item = new itemRankingNomes();
                item.setNome(item_array_json.getString("nome"));
                item.setFrequencia(item_array_json.getInt("frequencia"));
                item.setRanking(item_array_json.getInt("ranking"));

                dadosNomes.add(item.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dadosNomes);
            lst_ranking.setAdapter(adapter);

        }

    }
}

package com.github.frequencianomes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultadosActivity extends AppCompatActivity {

    JSONArray DadosAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Intent intent = this.getIntent();
        try {
            this.DadosAPI = new JSONArray(intent.getStringExtra("dadosAPI"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < DadosAPI.length(); i++) {
            try {
                Log.i("teste", String.valueOf(DadosAPI.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}

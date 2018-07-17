package service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import models.nomesFrequentes;

public class ibge_service extends AsyncTask<Void, Void, nomesFrequentes> {

    private final String genero;
    private String urlString = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking";
    private JSONObject dados_json;

    public ibge_service(String genero) {
        this.genero = genero;
    }

    @Override
    protected nomesFrequentes doInBackground(Void... voids) {
        StringBuilder str = new StringBuilder();

        try {
            if (this.genero.equals("Masculino")) {
                urlString = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking?sexo=M";
            }
            else if (this.genero.equals("Feminino")) {
                urlString = "https://servicodados.ibge.gov.br/api/v2/censos/nomes/ranking?sexo=F";
            }

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                str.append(scanner.next());
            }

            // como os dados estão em um array, é necessário criar um objeto do tipo JSONArray, e pegar a primeira posição da lista, onde estão as informações.

            try {
                JSONArray arrayDados = new JSONArray(str.toString());
                dados_json = new JSONObject(String.valueOf(arrayDados.get(0)));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(dados_json.toString(), nomesFrequentes.class);
    }
}

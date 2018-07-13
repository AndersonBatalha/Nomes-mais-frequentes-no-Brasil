package models;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class nomesFrequentes implements Serializable {
    private String localidade;
    private String sexo;
    private ArrayList res;

    public nomesFrequentes(String localidade, String sexo, ArrayList<JSONObject> res) {
        this.localidade = localidade;
        this.sexo = sexo;
        this.res = res;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList getRes() {
        return res;
    }

    public void setRes(ArrayList res) {
        this.res = res;
    }

}
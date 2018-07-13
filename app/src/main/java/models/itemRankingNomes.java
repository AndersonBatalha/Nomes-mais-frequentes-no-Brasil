package models;

public class itemRankingNomes {
    private String nome;
    private int frequencia;
    private int ranking;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public String toString() {
        return String.format("%6d %25s %25d", getRanking(), getNome(), getFrequencia());
    }

}

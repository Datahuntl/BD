package br.inatel.Model;

public class Enfermeiro {

    String nome;

    String coren;

    int id;

    public Enfermeiro(String nome, String coren, int id) {
        this.nome = nome;
        this.coren = coren;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCoren() {
        return coren;
    }
}

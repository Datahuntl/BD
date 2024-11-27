package br.inatel.Model;

public class Paciente {

    String nome;

    String nome_mae;

    String tipo_sangue;

    int id;

    public Paciente(String nome, String nome_mae, String tipo_sangue, int id) {
        this.nome = nome;
        this.nome_mae = nome_mae;
        this.tipo_sangue = tipo_sangue;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public String getTipo_sangue() {
        return tipo_sangue;
    }
}

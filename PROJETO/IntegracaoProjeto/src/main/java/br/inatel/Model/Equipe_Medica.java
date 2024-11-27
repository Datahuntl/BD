package br.inatel.Model;

public class Equipe_Medica {

    String nome;

    int medico_id;

    int id;

    public Equipe_Medica(String nome, int medico_id, int id) {
        this.nome = nome;
        this.medico_id = medico_id;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getMedico_id() {
        return medico_id;
    }
}

package br.inatel.Model;

public class Medico {

    String nome;

    String crm;

    String especialidade;

    int id;

    public Medico(String nome, String crm, String especialidade, int id) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}

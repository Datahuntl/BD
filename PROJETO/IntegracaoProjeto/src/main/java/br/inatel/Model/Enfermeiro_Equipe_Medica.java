package br.inatel.Model;

public class Enfermeiro_Equipe_Medica {

    int enfermeiro_id;

    int equipe_medica_id;

    public Enfermeiro_Equipe_Medica(int enfermeiro_id, int equipe_medica_id) {
        this.enfermeiro_id = enfermeiro_id;
        this.equipe_medica_id = equipe_medica_id;
    }

    public int getEnfermeiro_id() {
        return enfermeiro_id;
    }

    public int getEquipe_medica_id() {
        return equipe_medica_id;
    }
}

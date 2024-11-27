package br.inatel.Model;

public class Paciente_Equipe_Medica {

    int paciente_id;

    int equipe_medica_id;

    public Paciente_Equipe_Medica(int paciente_id, int equipe_medica_id) {
        this.paciente_id = paciente_id;
        this.equipe_medica_id = equipe_medica_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public int getEquipe_medica_id() {
        return equipe_medica_id;
    }
}

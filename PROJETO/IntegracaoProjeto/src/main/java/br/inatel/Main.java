package br.inatel;
import br.inatel.DAO.EnfermeiroDAO;
import br.inatel.DAO.Paciente_Equipe_MedicaDAO;
import br.inatel.DAO.Enfermeiro_Equipe_MedicaDAO;
import br.inatel.DAO.Equipe_MedicaDAO;
import br.inatel.DAO.MedicoDAO;
import br.inatel.DAO.PacienteDAO;
import br.inatel.DDL.*;
import br.inatel.Model.*;

public class Main {

    public static void main(String[] args) {

        //TESTE DE CONEXÃO
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.testConnection();

        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.testConnection();

        EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAO();
        enfermeiroDAO.testConnection();

        Equipe_MedicaDAO emDAO = new Equipe_MedicaDAO();
        emDAO.testConnection();

        Enfermeiro_Equipe_MedicaDAO eemDAO = new Enfermeiro_Equipe_MedicaDAO();
        eemDAO.testConnection();

        Paciente_Equipe_MedicaDAO pemDAO = new Paciente_Equipe_MedicaDAO();
        pemDAO.testConnection();

        //PACIENTES
        Paciente paciente1 = new Paciente("João da Silva", "Maria Souza", "A+", 1);
        Paciente paciente2 = new Paciente("Ana Oliveira", "Fernanda Pereira", "B-", 2);
        Paciente paciente3 = new Paciente("Carlos Santos", "Luiza Silva", "AB+", 3);
        Paciente paciente4 = new Paciente("Maria Gomes", "Ana Costa", "O-", 4);

        PacienteDDL pacienteDDL = new PacienteDDL();
        pacienteDDL.InsertPaciente(paciente1);
        pacienteDDL.InsertPaciente(paciente2);
        pacienteDDL.InsertPaciente(paciente3);
        pacienteDDL.InsertPaciente(paciente4);

        pacienteDDL.selectPaciente();

        //MEDICOS
        Medico medico1 = new Medico("Dr. João Almeida", "12345-SP", "Cardiologia", 1);
        Medico medico2 = new Medico("Dra. Ana Silva", "67890-RJ", "Pediatria", 2);
        Medico medico3 = new Medico("Dr. Carlos Oliveira", "23456-MG", "Neurologia", 3);
        Medico medico4 = new Medico("Dra. Maria Santos", "78901-DF", "Oftalmologia", 4);

        MedicoDDL medicoDDL = new MedicoDDL();
        medicoDDL.InsertMedico(medico1);
        medicoDDL.InsertMedico(medico2);
        medicoDDL.InsertMedico(medico3);
        medicoDDL.InsertMedico(medico4);

        medicoDDL.selectMedico();

        //ENFERMEIROS
        Enfermeiro enfermeiro1 = new Enfermeiro("Maria Silva", "MG123456", 1);
        Enfermeiro enfermeiro2 = new Enfermeiro("João Pedro", "MG987654", 2);
        Enfermeiro enfermeiro3 = new Enfermeiro("Ana Souza", "RJ543210", 3);
        Enfermeiro enfermeiro4 = new Enfermeiro("Carlos Santos", "SP12345", 4);

        EnfermeiroDDL enfermeiroDDL = new EnfermeiroDDL();
        enfermeiroDDL.InsertEnfermeiro(enfermeiro1);
        enfermeiroDDL.InsertEnfermeiro(enfermeiro2);
        enfermeiroDDL.InsertEnfermeiro(enfermeiro3);
        enfermeiroDDL.InsertEnfermeiro(enfermeiro4);

        enfermeiroDDL.selectEnfermeiro();

        //EQUIPES
        Equipe_Medica equipe1 = new Equipe_Medica("Equipe Cardiologica", 1, 1);
        Equipe_Medica equipe2 = new Equipe_Medica("Equipe Pediatrica",2 , 2);
        Equipe_Medica equipe3 = new Equipe_Medica("Equipe Neurologica", 3, 3);
        Equipe_Medica equipe4 = new Equipe_Medica("Equipe Oftalmologica", 4, 4);

        Equipe_MedicaDDL equipemDDL = new Equipe_MedicaDDL();
        equipemDDL.InsertEquipeMedica(equipe1);
        equipemDDL.InsertEquipeMedica(equipe2);
        equipemDDL.InsertEquipeMedica(equipe3);
        equipemDDL.InsertEquipeMedica(equipe4);

        equipemDDL.selectEquipeMedica();

        //PACIENTE EM EQUIPE
        Paciente_Equipe_Medica paciequipe1 = new Paciente_Equipe_Medica(1,1);
        Paciente_Equipe_Medica paciequipe2 = new Paciente_Equipe_Medica(1,2);
        Paciente_Equipe_Medica paciequipe3 = new Paciente_Equipe_Medica(3,3);
        Paciente_Equipe_Medica paciequipe4 = new Paciente_Equipe_Medica(4,4);

        Paciente_Equipe_MedicaDDL paciequipeDDL = new Paciente_Equipe_MedicaDDL();
        paciequipeDDL.InsertPaciente_Equipe_Medica(paciequipe1);
        paciequipeDDL.InsertPaciente_Equipe_Medica(paciequipe2);
        paciequipeDDL.InsertPaciente_Equipe_Medica(paciequipe3);
        paciequipeDDL.InsertPaciente_Equipe_Medica(paciequipe4);

        paciequipeDDL.selectPaciente_Equipe_Medica();

        //ENFERMEIRO EM EQUIPE
        Enfermeiro_Equipe_Medica enfquipe1 = new Enfermeiro_Equipe_Medica(1,1);
        Enfermeiro_Equipe_Medica enfquipe2 = new Enfermeiro_Equipe_Medica(2,2);
        Enfermeiro_Equipe_Medica enfquipe3 = new Enfermeiro_Equipe_Medica(3,3);
        Enfermeiro_Equipe_Medica enfquipe4 = new Enfermeiro_Equipe_Medica(4,4);

        Enfermeiro_Equipe_MedicaDDL enfquipeDDL = new Enfermeiro_Equipe_MedicaDDL();
        enfquipeDDL.InsertEnfermeiro_Equipe_Medica(enfquipe1);
        enfquipeDDL.InsertEnfermeiro_Equipe_Medica(enfquipe2);
        enfquipeDDL.InsertEnfermeiro_Equipe_Medica(enfquipe3);
        enfquipeDDL.InsertEnfermeiro_Equipe_Medica(enfquipe4);

        enfquipeDDL.selectPaciente_Equipe_Medica();


    }
}
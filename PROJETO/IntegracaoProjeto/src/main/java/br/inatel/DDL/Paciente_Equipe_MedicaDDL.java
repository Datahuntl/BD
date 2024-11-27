package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Equipe_Medica;
import br.inatel.Model.Paciente_Equipe_Medica;

import java.sql.SQLException;
import java.util.ArrayList;

public class Paciente_Equipe_MedicaDDL extends ConnectionDAO {

    public boolean InsertPaciente_Equipe_Medica(Paciente_Equipe_Medica pequipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO paciente_equipe_medica (paciente_id, equipe_medica_id) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pequipemedica.getPaciente_id());
            pst.setInt(2, pequipemedica.getEquipe_medica_id());
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean UpdatePaciente_Equipe_Medica(int id, Paciente_Equipe_Medica pequipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE paciente_equipe_medica SET paciente_id = ?, medico_id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pequipemedica.getPaciente_id());
            pst.setInt(2, pequipemedica.getEquipe_medica_id());
            pst.setInt(3, id);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean DeletePaciente_Equipe_Medica(int id)
    {
        connectToDb();

        boolean sucesso;

        String sql = "DELETE FROM paciente_equipe_medica WHERE paciente_id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Paciente_Equipe_Medica> selectPaciente_Equipe_Medica()
    {
        connectToDb();

        ArrayList<Paciente_Equipe_Medica> pequipem = new ArrayList<>();
        String sql = "SELECT * FROM paciente_equipe_medica";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Pacientes em Equipe Medicas:");

            while(rs.next()) {
                Paciente_Equipe_Medica userAux = new Paciente_Equipe_Medica(rs.getInt("paciente_id"), rs.getInt("equipe_medica_id"));
                System.out.println("ID Do Paciente: " + userAux.getPaciente_id() + "ID da Equipe Médica: " + userAux.getEquipe_medica_id());
                System.out.println("------------------------------------------------------------------------------------");
                pequipem.add(userAux);
            }

        } catch (SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return pequipem;
    }


}
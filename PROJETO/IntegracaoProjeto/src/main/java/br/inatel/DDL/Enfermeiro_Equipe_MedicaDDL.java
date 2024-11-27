package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Enfermeiro_Equipe_Medica;

import java.sql.SQLException;
import java.util.ArrayList;

public class Enfermeiro_Equipe_MedicaDDL extends ConnectionDAO {

    public boolean InsertEnfermeiro_Equipe_Medica(Enfermeiro_Equipe_Medica enfquipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO enfermeiro_equipe_medica (enfermeiro_id, equipe_medica_id) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, enfquipemedica.getEnfermeiro_id());
            pst.setInt(2, enfquipemedica.getEquipe_medica_id());
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

    public boolean UpdatePaciente_Equipe_Medica(int id, Enfermeiro_Equipe_Medica enfquipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE enfermeiro_equipe_medica SET enfermeiro_id = ?, equipe_medica_id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, enfquipemedica.getEnfermeiro_id());
            pst.setInt(2, enfquipemedica.getEquipe_medica_id());
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

        String sql = "DELETE FROM enfermeiro_equipe_medica WHERE enfermeiro_id = ?";

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

    public ArrayList<Enfermeiro_Equipe_Medica> selectPaciente_Equipe_Medica()
    {
        connectToDb();

        ArrayList<Enfermeiro_Equipe_Medica> enfquipemedica = new ArrayList<>();
        String sql = "SELECT * FROM enfermeiro_equipe_medica";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Enfermeiros em Equipe Medicas:");

            while(rs.next()) {
                Enfermeiro_Equipe_Medica userAux = new Enfermeiro_Equipe_Medica(rs.getInt("enfermeiro_id"), rs.getInt("equipe_medica_id"));
                System.out.println("ID dos Enfermeiros: " + userAux.getEnfermeiro_id() + "ID da Equipe Medica: " + userAux.getEquipe_medica_id());
                System.out.println("------------------------------------------------------------------------------------");
                enfquipemedica.add(userAux);
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
        return enfquipemedica;
    }


}
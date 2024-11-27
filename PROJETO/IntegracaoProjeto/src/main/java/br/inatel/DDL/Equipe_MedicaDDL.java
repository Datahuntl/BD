package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Equipe_Medica;

import java.sql.SQLException;
import java.util.ArrayList;

public class Equipe_MedicaDDL extends ConnectionDAO {

    public boolean InsertEquipeMedica(Equipe_Medica equipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO equipe_medica (nome, medico_id) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, equipemedica.getNome());
            pst.setInt(2, equipemedica.getMedico_id());
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

    public boolean UpdateEquipeMedica(int id, Equipe_Medica equipemedica)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE equipe_medica SET nome = ?, medico_id = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, equipemedica.getNome());
            pst.setInt(2, equipemedica.getMedico_id());
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

    public boolean DeleteEquipeMedica(int id)
    {
        connectToDb();

        boolean sucesso;

        String sql = "DELETE FROM equipe_medica WHERE id = ?";

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

    public ArrayList<Equipe_Medica> selectEquipeMedica()
    {
        connectToDb();

        ArrayList<Equipe_Medica> equipem = new ArrayList<>();
        String sql = "SELECT * FROM equipe_medica";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Equipe Medicas:");

            while(rs.next()) {
                Equipe_Medica userAux = new Equipe_Medica(rs.getString("nome"), rs.getInt("medico_id"), rs.getInt("id"));
                System.out.println("Nome: " + userAux.getNome() + "ID do Médico: " + userAux.getMedico_id());
                System.out.println("------------------------------------------------------------------------------------");
                equipem.add(userAux);
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
        return equipem;
    }


}

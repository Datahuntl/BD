package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Medico;

import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDDL extends ConnectionDAO {

    public boolean InsertMedico(Medico medico)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO medico (nome, crm, especialidade) VALUES (?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCrm());
            pst.setString(3, medico.getEspecialidade());
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

    public boolean UpdateMedico(int id, Medico medico)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE medico SET nome = ?, crm = ?, especialidade = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCrm());
            pst.setString(3, medico.getEspecialidade());
            pst.setInt(4, id);
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

    public boolean DeleteMedico(int id)
    {
        connectToDb();

        boolean sucesso;

        String sql = "DELETE FROM medico WHERE id = ?";

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

    public ArrayList<Medico> selectMedico()
    {
        connectToDb();

        ArrayList<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Medicos:");

            while(rs.next()) {
                Medico userAux = new Medico(rs.getString("nome"), rs.getString("crm"), rs.getString("especialidade"), rs.getInt("id"));
                System.out.println("Nome: " + userAux.getNome() + "CRM: " + userAux.getCrm() + "Especialidade: " + userAux.getEspecialidade());
                System.out.println("------------------------------------------------------------------------------------");
                medicos.add(userAux);
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
        return medicos;
    }


}

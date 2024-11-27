package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Enfermeiro;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnfermeiroDDL extends ConnectionDAO {

    public boolean InsertEnfermeiro(Enfermeiro enfermeiro)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO enfermeiro (nome, coren) VALUES (?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, enfermeiro.getNome());
            pst.setString(2, enfermeiro.getCoren());
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

    public boolean UpdateEnfermeiro(int id, Enfermeiro enfermeiro)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE enfermeiro SET nome = ?, coren = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, enfermeiro.getNome());
            pst.setString(2, enfermeiro.getCoren());
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

    public boolean DeleteEnfermeiro(int id)
    {
        connectToDb();

        boolean sucesso;

        String sql = "DELETE FROM enfermeiro WHERE id = ?";

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

    public ArrayList<Enfermeiro> selectEnfermeiro()
    {
        connectToDb();

        ArrayList<Enfermeiro> enfermeiros = new ArrayList<>();
        String sql = "SELECT * FROM enfermeiro";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Enfermeiros:");

            while(rs.next()) {
                Enfermeiro userAux = new Enfermeiro(rs.getString("nome"), rs.getString("coren"), rs.getInt("id"));
                System.out.println("Nome: " + userAux.getNome() + "COREN: " + userAux.getCoren());
                System.out.println("------------------------------------------------------------------------------------");
                enfermeiros.add(userAux);
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
        return enfermeiros;
    }


}

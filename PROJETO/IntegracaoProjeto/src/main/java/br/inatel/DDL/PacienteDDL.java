package br.inatel.DDL;

import br.inatel.DAO.ConnectionDAO;
import br.inatel.Model.Paciente;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDDL extends ConnectionDAO {

    public boolean InsertPaciente(Paciente paciente)
    {
        connectToDb();

        boolean sucesso;

        String sql = "INSERT INTO paciente (nome, nome_mae, tipo_sangue) VALUES (?, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getNome_mae());
            pst.setString(3, paciente.getTipo_sangue());
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

    public boolean UpdatePaciente(int id, Paciente paciente)
    {
        connectToDb();

        boolean sucesso;

        String sql = "UPDATE paciente SET nome = ?, nome_mae = ?, tipo_sangue = ? WHERE id = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getNome_mae());
            pst.setString(3, paciente.getTipo_sangue());
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

    public boolean DeletePaciente(int id)
    {
        connectToDb();

        boolean sucesso;

        String sql = "DELETE FROM paciente WHERE id = ?";

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

    public ArrayList<Paciente> selectPaciente()
    {
        connectToDb();

        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Pacientes:");

            while(rs.next()) {
                Paciente userAux = new Paciente(rs.getString("nome"), rs.getString("nome_mae"), rs.getString("tipo_sangue"), rs.getInt("id"));
                System.out.println("Nome: " + userAux.getNome() + "Nome da Mãe: " + userAux.getNome_mae() + "Tipo Sangue: " + userAux.getTipo_sangue());
                System.out.println("------------------------------------------------------------------------------------");
                pacientes.add(userAux);
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
        return pacientes;
    }


}

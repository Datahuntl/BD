package br.inatel.DAO;

import java.sql.*;

public abstract class ConnectionDAO {

    public Connection con; //conexão
    public PreparedStatement pst; //declaração(query) preparada - código em sql
    public Statement st; //declaração(query) - código em sql
    public ResultSet rs; //resposta do banco

    String database = "PROJETO"; //nome do BD
    String user = "root";
    String password = "tubarao220";
    String url = "jdbc:mysql://localhost:3306/" + database
            + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}

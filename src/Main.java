import java.sql.*;

public class Main {


    public static void main(String[] args) {
        String urlBanco = "jdbc:mysql://localhost:3306/db_integracao";
        String username = "root";
        String senha = "root";

        try (Connection connection = DriverManager.getConnection(urlBanco, username, senha)) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
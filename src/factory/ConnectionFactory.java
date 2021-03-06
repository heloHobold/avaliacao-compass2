package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "data"; // -> informar da alteração no README
    private static final String DATABASE_URL = "jdbc:mysql://localhost/avaliacaoCompass2?useTimezone=true&serverTimezone=UTC";

    public static Connection criarConexao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexao {
    private static final String url = "jdbc:mysql://localhost:3306/eventodb";
    private static final String user = "root";
    private static final String password = "";
    private static Connection con = null;

    // "Singleton", conector do banco de dados que garante uma única conexão.
    private static Connection startConnection() throws SQLException {
        if (con != null && !con.isClosed()) {
            return con;
        }

        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    // Fecha a conexão com o banco de dados.
    public static void closeConnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    // Executa a query.
    public static ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = startConnection().createStatement();
        return stmt.executeQuery(query);
    }

    // Prepara a query.
    public static PreparedStatement prepareStatement(String query) throws SQLException {
        return startConnection().prepareStatement(query);
    }
}
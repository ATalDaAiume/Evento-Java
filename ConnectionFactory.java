public class ConnectionFactory {
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/seu_banco";
            String user = "seu_usuario";
            String password = "sua_senha";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erro de conexão com o banco de dados", e);
        }
    }
}

}

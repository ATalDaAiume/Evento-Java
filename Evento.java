import java.sql.*;

public class Evento {
    int idEvento;
    String descricao;
    int vagas;
    int idOrganizador;

    // Construtor
    public Evento(String descricao, int vagas, int idOrganizador) {
        this.descricao = descricao;
        this.vagas = vagas;
        this.idOrganizador = idOrganizador;
    }

    // Salvar evento no banco de dados (CRUD - Create)
    public void salvar() {
        String query = "INSERT INTO Evento (descricao, vagas, idOrganizador) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, descricao);
            stmt.setInt(2, vagas);
            stmt.setInt(3, idOrganizador);
            stmt.executeUpdate();

            // Obtém o ID gerado automaticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.idEvento = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualizar evento no banco de dados (CRUD - Update)
    public void atualizar() {
        String query = "UPDATE Evento SET descricao = ?, vagas = ? WHERE idEvento = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, descricao);
            stmt.setInt(2, vagas);
            stmt.setInt(3, idEvento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar evento do banco de dados (CRUD - Delete)
    public void deletar() {
        String query = "DELETE FROM Evento WHERE idEvento = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idEvento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar evento pelo ID (CRUD - Read)
    public static Evento buscarPorId(int id) {
        String query = "SELECT * FROM Evento WHERE idEvento = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String descricao = rs.getString("descricao");
                int vagas = rs.getInt("vagas");
                int idOrganizador = rs.getInt("idOrganizador");
                Evento evento = new Evento(descricao, vagas, idOrganizador);
                evento.idEvento = id;
                return evento;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

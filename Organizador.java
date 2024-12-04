import java.sql.*;
import java.util.ArrayList;

public class Organizador extends Pessoa {
    private String departamento;
    private String email;
    private String telefone;

    // Lista estática para armazenar organizadores em memória
    private static ArrayList<Organizador> organizadores = new ArrayList<>();

    public Organizador(String nome, String departamento, String email, String telefone) {
        super(nome, "Organizador");
        this.departamento = departamento;
        this.email = email;
        this.telefone = telefone;
    }

    // CRUD: Adicionar organizador
    public static void adicionarOrganizador(Organizador organizador) {
        String sql = "INSERT INTO Organizador (nome, tipo, departamento, email, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, organizador.getNome());
            stmt.setString(2, organizador.getTipo());
            stmt.setString(3, organizador.departamento);
            stmt.setString(4, organizador.email);
            stmt.setString(5, organizador.telefone);
            stmt.executeUpdate();
            organizadores.add(organizador); // Adiciona à lista em memória após inserir no banco
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar organizador: " + e.getMessage());
        }
    }

    // CRUD: Listar organizadores
    public static ArrayList<Organizador> listarOrganizadores() {
        return organizadores;
    }

    // CRUD: Atualizar organizador
    public static void atualizarOrganizador(int id, String novoNome, String novoDepto, String novoEmail, String novoTelefone) {
        for (Organizador organizador : organizadores) {
            if (organizador.getId() == id) {
                organizador.nome = novoNome;
                organizador.departamento = novoDepto;
                organizador.email = novoEmail;
                organizador.telefone = novoTelefone;

                // Atualiza no banco de dados
                String sql = "UPDATE Organizador SET nome=?, departamento=?, email=?, telefone=? WHERE id=?";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, novoNome);
                    stmt.setString(2, novoDepto);
                    stmt.setString(3, novoEmail);
                    stmt.setString(4, novoTelefone);
                    stmt.setInt(5, id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erro ao atualizar organizador: " + e.getMessage());
                }
                break;
            }
        }
    }

    // CRUD: Deletar organizador
    public static void deletarOrganizador(int id) {
        organizadores.removeIf(organizador -> organizador.getId() == id);

        // Deletar no banco de dados
        String sql = "DELETE FROM Organizador WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar organizador: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Organizador [id=" + getId() + ", nome=" + getNome() + ", departamento=" + departamento + ", email=" + email + ", telefone=" + telefone + "]";
    }
}

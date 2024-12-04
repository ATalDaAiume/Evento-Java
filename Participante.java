import java.sql.*;
import java.util.ArrayList;

public class Participante extends Pessoa {
    private String departamento;
    private String email;
    private String telefone;

    // Lista estática para armazenar participantes em memória
    private static ArrayList<Participante> participantes = new ArrayList<>();

    public Participante(String nome, String departamento, String email, String telefone) {
        super(nome, "Participante");
        this.departamento = departamento;
        this.email = email;
        this.telefone = telefone;
    }

    // CRUD: Adicionar participante
    public static void adicionarParticipante(Participante participante) {
        String sql = "INSERT INTO Participante (nome, tipo, departamento, email, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, participante.getNome());
            stmt.setString(2, participante.getTipo());
            stmt.setString(3, participante.departamento);
            stmt.setString(4, participante.email);
            stmt.setString(5, participante.telefone);
            stmt.executeUpdate();
            participantes.add(participante); // Adiciona à lista em memória após inserir no banco
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar participante: " + e.getMessage());
        }
    }

    // CRUD: Listar participantes
    public static ArrayList<Participante> listarParticipantes() {
        return participantes;
    }

    // CRUD: Atualizar participante
    public static void atualizarParticipante(int id, String novoNome, String novoDepto, String novoEmail, String novoTelefone) {
        for (Participante participante : participantes) {
            if (participante.getId() == id) {
                participante.nome = novoNome;
                participante.departamento = novoDepto;
                participante.email = novoEmail;
                participante.telefone = novoTelefone;

                // Atualiza no banco de dados
                String sql = "UPDATE Participante SET nome=?, departamento=?, email=?, telefone=? WHERE id=?";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, novoNome);
                    stmt.setString(2, novoDepto);
                    stmt.setString(3, novoEmail);
                    stmt.setString(4, novoTelefone);
                    stmt.setInt(5, id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erro ao atualizar participante: " + e.getMessage());
                }
                break;
            }
        }
    }

    // CRUD: Deletar participante
    public static void deletarParticipante(int id) {
        participantes.removeIf(participante -> participante.getId() == id);

        // Deletar no banco de dados
        String sql = "DELETE FROM Participante WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar participante: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Participante [id=" + getId() + ", nome=" + getNome() + ", departamento=" + departamento + ", email=" + email + ", telefone=" + telefone + "]";
    }
}

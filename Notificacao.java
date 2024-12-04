import java.sql.*;
import java.util.ArrayList;

public class Notificacao {
    private static int idCounter = 1;
    private int id;
    private String tipo;
    private String mensagem;

    // Lista estática para armazenar as notificações em memória
    private static ArrayList<Notificacao> notificacoes = new ArrayList<>();

    public Notificacao(String tipo, String mensagem) {
        this.id = idCounter++;
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    // CRUD: Adicionar notificação
    public static void adicionarNotificacao(Notificacao notificacao) {
        String sql = "INSERT INTO Notificacao (tipo, mensagem) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notificacao.tipo);
            stmt.setString(2, notificacao.mensagem);
            stmt.executeUpdate();
            notificacoes.add(notificacao); // Adiciona à lista em memória após inserir no banco
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar notificação: " + e.getMessage());
        }
    }

    // CRUD: Listar notificações
    public static ArrayList<Notificacao> listarNotificacoes() {
        return notificacoes;
    }

    // CRUD: Atualizar notificação
    public static void atualizarNotificacao(int id, String novoTipo, String novaMensagem) {
        for (Notificacao notificacao : notificacoes) {
            if (notificacao.getId() == id) {
                notificacao.tipo = novoTipo;
                notificacao.mensagem = novaMensagem;

                // Atualiza no banco de dados
                String sql = "UPDATE Notificacao SET tipo=?, mensagem=? WHERE id=?";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, novoTipo);
                    stmt.setString(2, novaMensagem);
                    stmt.setInt(3, id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erro ao atualizar notificação: " + e.getMessage());
                }
                break;
            }
        }
    }

    // CRUD: Deletar notificação
    public static void deletarNotificacao(int id) {
        notificacoes.removeIf(notificacao -> notificacao.getId() == id);

        // Deletar no banco de dados
        String sql = "DELETE FROM Notificacao WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar notificação: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Notificacao [id=" + id + ", tipo=" + tipo + ", mensagem=" + mensagem + "]";
    }
}
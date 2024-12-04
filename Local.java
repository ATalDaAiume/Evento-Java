import java.sql.*;
import java.util.ArrayList;

public class Local {
    private static int idCounter = 1;
    private int id;
    private String nome;
    private String endereco;

    // Lista estática para armazenar os locais em memória
    private static ArrayList<Local> locais = new ArrayList<>();

    public Local(String nome, String endereco) {
        this.id = idCounter++;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    // CRUD: Adicionar local
    public static void adicionarLocal(Local local) {
        String sql = "INSERT INTO Local (nome, endereco) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, local.nome);
            stmt.setString(2, local.endereco);
            stmt.executeUpdate();
            locais.add(local); // Adiciona à lista em memória após inserir no banco
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar local: " + e.getMessage());
        }
    }

    // CRUD: Listar locais
    public static ArrayList<Local> listarLocais() {
        return locais;
    }

    // CRUD: Atualizar local
    public static void atualizarLocal(int id, String novoNome, String novoEndereco) {
        for (Local local : locais) {
            if (local.getId() == id) {
                local.nome = novoNome;
                local.endereco = novoEndereco;

                // Atualiza no banco de dados
                String sql = "UPDATE Local SET nome=?, endereco=? WHERE id=?";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, novoNome);
                    stmt.setString(2, novoEndereco);
                    stmt.setInt(3, id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erro ao atualizar local: " + e.getMessage());
                }
                break;
            }
        }
    }

    // CRUD: Deletar local
    public static void deletarLocal(int id) {
        locais.removeIf(local -> local.getId() == id);

        // Deletar no banco de dados
        String sql = "DELETE FROM Local WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar local: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Local [id=" + id + ", nome=" + nome + ", endereco=" + endereco + "]";
    }
}

// ConnectionFactory Class
class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/sua_base_de_dados"; // Substitua pelo URL do seu banco
    private static final String USER = "seu_usuario"; // Substitua pelo seu usuário
    private static final String PASSWORD = "sua_senha"; // Substitua pela sua senha

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
import java.sql.*;
import java.util.ArrayList;

<<<<<<< HEAD
public abstract class Pessoa {
    private static int idCounter = 1;
    private int id;
    private String nome;
    private String tipo;

    // Lista estática para armazenar as pessoas em memória
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Pessoa(String nome, String tipo) {
        this.id = idCounter++;
        this.nome = nome;
        this.tipo = tipo;
        pessoas.add(this); // Adiciona a pessoa à lista em memória
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public static ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public static Pessoa buscarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
=======
public class Pessoa {
    int idPessoa;
    String nome;
    String tipo;  // 'organizador' ou 'participante'
    String email;
    String telefone;

    // Construtor
    public Pessoa(String nome, String tipo, String email, String telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.telefone = telefone;
    }

    // Salvar pessoa no banco de dados (CRUD - Create)
    public void salvar() {
        String query = "INSERT INTO Pessoa (nome, tipo, email, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.executeUpdate();

            // Obtém o ID gerado automaticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.idPessoa = rs.getInt(1);
>>>>>>> ba815584a8fdf9b10717f7ee246a0bdadc7699ad
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        return null;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
=======
    }

    // Atualizar pessoa no banco de dados (CRUD - Update)
    public void atualizar() {
        String query = "UPDATE Pessoa SET nome = ?, tipo = ?, email = ?, telefone = ? WHERE idPessoa = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setInt(5, idPessoa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar pessoa do banco de dados (CRUD - Delete)
    public void deletar() {
        String query = "DELETE FROM Pessoa WHERE idPessoa = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Consultar uma pessoa pelo ID (CRUD - Read)
    public static Pessoa buscarPorId(int id) {
        String query = "SELECT * FROM Pessoa WHERE idPessoa = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Pessoa pessoa = new Pessoa(nome, tipo, email, telefone);
                pessoa.idPessoa = id;
                return pessoa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todas as pessoas (CRUD - Read)
    public static ArrayList<Pessoa> listarPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        String query = "SELECT * FROM Pessoa";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Pessoa pessoa = new Pessoa(nome, tipo, email, telefone);
                pessoa.idPessoa = rs.getInt("idPessoa");
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
>>>>>>> ba815584a8fdf9b10717f7ee246a0bdadc7699ad
    }
}

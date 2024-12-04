import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Evento {
    private int idEvento;
    private String descricao;
    private int vagas;
    private int idOrganizador;

    // Lista para armazenar eventos em memória
    private static ArrayList<Evento> eventos = new ArrayList<>();

    // Construtor
    public Evento(String descricao, int vagas, int idOrganizador) {
        this.descricao = descricao;
        this.vagas = vagas;
        this.idOrganizador = idOrganizador;
    }

    // Getters
    public int getIdEvento() {
        return idEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getVagas() {
        return vagas;
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    // Método para salvar o evento no banco de dados
    public void salvar() {
        String sql = "INSERT INTO Evento (descricao, vagas, idOrganizador) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            stmt.setInt(2, vagas);
            stmt.setInt(3, idOrganizador);

            stmt.executeUpdate();
            System.out.println("Evento salvo com sucesso no banco de dados!");

            // Adiciona o evento à lista em memória
            eventos.add(this);
        } catch (SQLException e) {
            System.out.println("Erro ao salvar evento: " + e.getMessage());
        }
    }

    // Método para listar todos os eventos
    public static ArrayList<Evento> listarEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        return "Evento [idEvento=" + idEvento + ", descricao=" + descricao +
                ", vagas=" + vagas + ", idOrganizador=" + idOrganizador + "]";
    }
}
import java.sql.*;
import java.util.Scanner;

public class Menu {

    // Método para exibir o menu
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        // Exibindo as opções do menu
        System.out.println("-------- Menu do Sistema --------");
        System.out.println("1. Criar Evento");
        System.out.println("2. Adicionar Pessoa (Organizador/Participante)");
        System.out.println("3. Criar Local");
        System.out.println("4. Enviar Notificação");
        System.out.println("5. Listar Eventos");
        System.out.println("6. Listar Pessoas");
        System.out.println("7. Listar Locais");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        // Processando a opção escolhida
        switch (opcao) {
            case 1:
                criarEvento(scanner);
                break;
            case 2:
                adicionarPessoa(scanner);
                break;
            case 3:
                criarLocal(scanner);
                break;
            case 4:
                enviarNotificacao(scanner);
                break;
            case 5:
                listarEventos();
                break;
            case 6:
                listarPessoas();
                break;
            case 7:
                listarLocais();
                break;
            case 8:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }

    // Método para criar um evento
    private static void criarEvento(Scanner scanner) {
        System.out.print("Nome do Evento: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição do Evento: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de Início (YYYY-MM-DD HH:MM:SS): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de Fim (YYYY-MM-DD HH:MM:SS): ");
        String dataFim = scanner.nextLine();

        // Inserindo evento no banco de dados
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Evento (nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, dataInicio);
                stmt.setString(4, dataFim);
                stmt.executeUpdate();
                System.out.println("Evento criado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar uma pessoa (Organizador ou Participante)
    private static void adicionarPessoa(Scanner scanner) {
        System.out.print("Nome da Pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo (Organizador/Participante): ");
        String tipo = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        // Inserindo pessoa no banco de dados
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Pessoa (nome, tipo, departamento, email, telefone) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, tipo);
                stmt.setString(3, departamento);
                stmt.setString(4, email);
                stmt.setString(5, telefone);
                stmt.executeUpdate();
                System.out.println("Pessoa adicionada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para criar um local
    private static void criarLocal(Scanner scanner) {
        System.out.print("Nome do Local: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço do Local: ");
        String endereco = scanner.nextLine();

        // Inserindo local no banco de dados
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Local (nome, endereco) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, endereco);
                stmt.executeUpdate();
                System.out.println("Local criado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para enviar uma notificação
    private static void enviarNotificacao(Scanner scanner) {
        System.out.print("Tipo de Notificação (Email, SMS, etc.): ");
        String tipo = scanner.nextLine();
        System.out.print("Mensagem da Notificação: ");
        String mensagem = scanner.nextLine();

        // Inserindo notificação no banco de dados
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Notificacao (tipo, mensagem) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, tipo);
                stmt.setString(2, mensagem);
                stmt.executeUpdate();
                System.out.println("Notificação enviada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os eventos
    private static void listarEventos() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM Evento";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Descrição: " + rs.getString("descricao"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas as pessoas
    private static void listarPessoas() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM Pessoa";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Tipo: " + rs.getString("tipo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os locais
    private static void listarLocais() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM Local";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Endereço: " + rs.getString("endereco"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método principal que inicia o menu
    public static void main(String[] args) {
        while (true) {
            exibirMenu();
        }
    }
}
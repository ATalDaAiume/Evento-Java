import java.util.Scanner;

public class SistemaEventos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu do Sistema de Eventos:");
            System.out.println("1. Criar Pessoa (Organizador ou Participante)");
            System.out.println("2. Criar Evento");
            System.out.println("3. Consultar Pessoas");
            System.out.println("4. Consultar Eventos");
            System.out.println("5. Atualizar Pessoa");
            System.out.println("6. Atualizar Evento");
            System.out.println("7. Deletar Pessoa");
            System.out.println("8. Deletar Evento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (opcao == 1) {
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o tipo (organizador/participante): ");
                String tipo = scanner.nextLine();

                if (tipo.equalsIgnoreCase("organizador")) {
                    System.out.print("Digite o departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();

                    Organizador organizador = new Organizador(nome, departamento, email, telefone);
                    Organizador.adicionarOrganizador(organizador);
                    System.out.println("Organizador criado com sucesso!");

                } else if (tipo.equalsIgnoreCase("participante")) {
                    System.out.print("Digite o departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();

                    Participante participante = new Participante(nome, departamento, email, telefone);
                    Participante.adicionarParticipante(participante);
                    System.out.println("Participante criado com sucesso!");

                } else {
                    System.out.println("Tipo inválido. Escolha 'organizador' ou 'participante'.");
                }

            } else if (opcao == 2) {
                System.out.print("Digite a descrição do evento: ");
                String descricao = scanner.nextLine();
                System.out.print("Digite o número de vagas: ");
                int vagas = scanner.nextInt();
                System.out.print("Digite o ID do organizador: ");
                int idOrganizador = scanner.nextInt();

                Evento evento = new Evento(descricao, vagas, idOrganizador);
                evento.salvar();
                System.out.println("Evento criado com sucesso!");

            } else if (opcao == 3) {
                System.out.println("Pessoas cadastradas:");
                for (Pessoa p : Pessoa.getPessoas()) {
                    System.out.println(p);
                }

            } else if (opcao == 4) {
                System.out.println("Eventos cadastrados:");
                // Exemplo de como listar eventos
                // Aqui você pode implementar uma consulta para exibir todos os eventos

            } else if (opcao == 5) {
                // Implementar atualização de pessoa

            } else if (opcao == 6) {
                // Implementar atualização de evento

            } else if (opcao == 7) {
                // Implementar remoção de pessoa

            } else if (opcao == 8) {
                // Implementar remoção de evento

            } else if (opcao == 0) {
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
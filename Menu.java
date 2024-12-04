import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Menu Escola");
        Scanner scanner = new Scanner(System.in);  // Criando um Scanner para entrada de dados
        int opt = 0;  // Variável que guarda a opção selecionada pelo usuário

        do {
            // Exibição das opções do menu
            System.out.println("1 - Cadastrar Organizador");
            System.out.println("2 - Cadastrar Evento");
            System.out.println("3 - Cadastrar Participante");
            System.out.println("4 - Listar Organizador");
            System.out.println("5 - Listar Evento");
            System.out.println("6 - Listar Participante");
            System.out.println("7 - Listar Notificações");
            System.out.println("8 - Enviar Notificação");
            System.out.println("9 - Sair");

            try {
                // Tentando capturar a opção escolhida pelo usuário
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;  // Se o usuário digitar um valor inválido, a opção será 0
            }

            // Switch para tratar cada opção do menu
            switch (opt) {
                case 1:
                    try {
                        // Cadastro de Organizador
                        System.out.println("Cadastre Organizador");
                        System.out.println("Digite o Id do Organizador: ");
                        int idProfessor = scanner.nextInt();
                        System.out.println("Digite o Nome do Organizador: ");
                        String nome = scanner.next();
                        System.out.println("Digite o Departamento do Organizador: ");
                        String departamento = scanner.next();
                        // Criação de um novo objeto Organizador
                        new Organizador(idProfessor, nome, departamento);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Organizador");
                    }
                    break;
                case 2:
                    try {
                        // Cadastro de Evento
                        System.out.println("Cadastrar Evento");
                        System.out.println("Digite o Id do Evento: ");
                        int idEvento = scanner.nextInt();
                        System.out.println("Digite a Descrição do Evento: ");
                        String descricao = scanner.next();
                        System.out.println("Digite a Data do Evento: ");
                        int data = scanner.nextInt();
                        System.out.println("Digite o número de vagas: ");
                        int vagas = scanner.nextInt();
                        // Criação de um novo evento
                        new Evento(idEvento, descricao, data, vagas);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Evento");
                    }
                    break;
                case 3:
                    try {
                        // Cadastro de Participante
                        System.out.println("Cadastrar Participante");
                        System.out.println("Digite o Id do Participante: ");
                        int idParticipante = scanner.nextInt();
                        System.out.println("Digite o Nome do Participante: ");
                        String nomeParticipante = scanner.next();
                        System.out.println("Digite o Departamento do Participante: ");
                        String departamentoParticipante = scanner.next();
                        // Criação de um novo Participante
                        new Participante(nomeParticipante, departamentoParticipante);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar o Participante");
                    }
                    break;
                case 4:
                    // Listar todos os Organizadores
                    System.out.println("Listar Organizadores");
                    for (Organizador organizador : Organizador.organizadores) {
                        // Exibição das informações dos Organizadores
                        System.out.println("Nome: " + organizador.nome + " Departamento: " + organizador.departamento);
                    }
                    break;
                case 5:
                    // Listar todos os Eventos
                    System.out.println("Listar Eventos");
                    for (Evento evento : Evento.eventos) {
                        // Exibição das informações dos Eventos
                        System.out.println("Evento: " + evento.descricao + " Data: " + evento.data + " Vagas: " + evento.vagas);
                    }
                    break;
                case 6:
                    // Listar todos os Participantes
                    System.out.println("Listar Participantes");
                    for (Participante participante : Participante.participantes) {
                        // Exibição das informações dos Participantes
                        System.out.println("Nome: " + participante.nome + " Departamento: " + participante.departamento);
                    }
                    break;
                case 7:
                    // Listar todas as notificações
                    System.out.println("Listar Notificações");
                    for (Notificacao notificacao : Notificacao.notificacoes) {
                        // Exibição das informações das notificações
                        System.out.println("Notificação para " + notificacao.destinatario + " Tipo: " + notificacao.tipo +
                                           " Status: " + notificacao.status + " Mensagem: " + notificacao.mensagem);
                    }
                    break;
                case 8:
                    // Enviar Notificação
                    try {
                        System.out.println("Enviar Notificação");
                        System.out.println("Digite o tipo da notificação (email ou telefone): ");
                        String tipoNotificacao = scanner.next();
                        System.out.println("Digite a mensagem da notificação: ");
                        String mensagem = scanner.next();
                        System.out.println("Digite o destinatário (nome): ");
                        String destinatario = scanner.next();

                        // Criação de uma nova notificação
                        Notificacao not = new Notificacao(1, mensagem, destinatario, tipoNotificacao);
                        not.enviarNotificacao();
                        System.out.println("Notificação enviada!");
                    } catch (Exception e) {
                        System.out.println("Erro ao enviar notificação: " + e.getMessage());
                    }
                    break;
                case 9:
                    // Finalizando o programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Tratamento de opção inválida
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opt != 9);  // O loop continua até que o usuário escolha a opção de sair (9)

        scanner.close();  // Fechando o scanner para liberar os recursos
    }
}

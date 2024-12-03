import java.util.ArrayList;

public class Organizador {

    // Atributos do Organizador
    String email;
    String notifica;

    // Lista estática que armazena todos os organizadores criados
    static ArrayList<Organizador> organizadores = new ArrayList<>();

    // Construtor que inicializa o Organizador
    public Organizador(String nome, String departamento) {
        this.nome = nome;
        this.departamento = departamento;

        // Adiciona o Organizador à lista de organizadores
        organizadores.add(this);
    }

    // Método estático que verifica se um Organizador com determinado ID existe
    static void verificaId(int id) throws Exception {
        for (Organizador organizador : organizadores) {
            // Se o Organizador com o ID fornecido for encontrado, a função retorna sem erro
            if (organizador.id == id) {
                return;
            }
        }
        // Se não encontrar o Organizador, lança uma exceção
        throw new Exception("Organizador não encontrado");
    }

    // Método estático que busca um Organizador pelo ID
    static Organizador buscaOrganizador(int id) {
        for (Professor organizador : organizadores) {
            // Se encontrar o organizador com o ID correspondente, retorna o Organizador
            if (organizador.id == id) {
                return organizador;
            }
        }
        return null; // Retorna null se o Organizador não for encontrado
    }
}

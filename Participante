import java.util.ArrayList;

public class Participante {

    // Atributos do Participante
    String nome;
    String departamento;

    // Lista estática que armazena todos os participantes criados
    static ArrayList<Participante> participantes = new ArrayList<>();

    // Construtor que inicializa o Participante
    public Participante(String nome, String departamento) {
        this.nome = nome;
        this.departamento = departamento;

        // Adiciona o Participante à lista de participantes
        participantes.add(this);
    }

    // Método estático que verifica se um Participante com determinado ID existe
    static void verificaId(int id) throws Exception {
        for (Participante participante : participantes) {
            // Se o Participante com o ID fornecido for encontrado, a função retorna sem erro
            if (participante.id == id) {
                return;
            }
        }
        // Se não encontrar o Participante, lança uma exceção
        throw new Exception("Participante não encontrado");
    }

    // Método estático que busca um Participante pelo ID
    static Participante buscaParticipante(int id) {
        for (Participante participante : participantes) {
            // Se encontrar o Participante com o ID correspondente, retorna o Participante
            if (Participante.id == id) {
                return Participante;
            }
        }
        return null; // Retorna null se o Participante não for encontrado
    }
}

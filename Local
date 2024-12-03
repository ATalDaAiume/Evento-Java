import java.util.ArrayList;

public class Local {

    // Atributos do local
    int id;
    String nome;
    int horas;
    int idProfessor;

    Professor professor; // Referência ao professor responsável pelo local

    // Lista estática que armazena todos os locais criados
    static ArrayList<Local> locais = new ArrayList<>();
    
    // Construtor que inicializa o curso com um ID de professor
    public Local(int id, String nome, int horas, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.idProfessor = idProfessor;

        // Adiciona o local à lista de locais
        locais.add(this);
    }

    // Construtor alternativo que recebe diretamente um objeto Professor
    public Local(int id, String nome, int horas, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.professor = professor;

        // Adiciona o local à lista de locais
        locais.add(this);
    }

    // Método estático para buscar um local pelo seu ID
    static Local buscaLocal(int id) {
        for (Local local : locais) {
            // Se encontrar o local com o ID correspondente, retorna o local
            if (local.id == id) {
                return local;
            }
        }
        return null; // Retorna null se o local não for encontrado
    }

    // Método estático que conta quantos locais são ministrados por um professor específico
    static int contarLocaisdeEvento(int idProfessor) {
        int cont = 0;
        for (Local local : locais) {
            // Verifica se o ID do professor do local corresponde ao ID fornecido
            if (local.idProfessor == idProfessor) {
                cont++;
            }
        }
        return cont;
    }
}

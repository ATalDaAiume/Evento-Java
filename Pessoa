import java.util.ArrayList;

public class Pessoa {
    
    // Atributos da pessoa
    int idPessoa;
    String nome;

    Organizador organizador;
    Participante participante;

    // Lista estática que armazena todas as Pessoas criadas
    static ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    // Construtor que inicializa a pessoa... Não sei se deve ser com Organizador ou participante ainda
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;

        // Adiciona a pessoa à lista de pessoas
        pessoas.add(this);
    }

    // Construtor alternativo que recebe diretamente um objeto
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;

        // Adiciona a pessoa à lista de pessoas
        pessoas.add(this);
    }

    // Método estático que conta quantas pessoas são organizadoras
    static int contarOrganizador(int idOrganizador) {
        int cont = 0;
        for (Pessoa pessoa : pessoas) {
            // Verifica se o ID do organizador corresponde ao ID fornecido
            if (pessoa.idOrganizador == idOrganizador) {
                cont++;
            }

    // Método estático que conta quantas pessoas são participantes
    static int contarParticipante(int idParticipante) {
        int cont = 0;
        for (Pessoa pessoa : pessoas) {
            // Verifica se o ID do participante corresponde ao ID fornecido
            if (pessoa.idParticipante == idParticipante) {
                cont++;
            }
        }
        return cont;
    }
}

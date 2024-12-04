import java.util.ArrayList;

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
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
    }
}

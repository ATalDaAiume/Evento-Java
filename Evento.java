import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private static int idCounter = 1;
    private int id;
    private String nome;
    private String localizacao;
    private Date data;

    // Lista estática para armazenar eventos em memória
    private static ArrayList<Evento> eventos = new ArrayList<>();

    public Evento(String nome, String localizacao, Date data) {
        this.id = idCounter++;
        this.nome = nome;
        this.localizacao = localizacao;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public Date getData() {
        return data;
    }

    // CRUD: Adicionar evento
    public static void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    // CRUD: Listar eventos
    public static ArrayList<Evento> listarEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", nome=" + nome + ", localizacao=" + localizacao + ", data=" + data + "]";
    }
}

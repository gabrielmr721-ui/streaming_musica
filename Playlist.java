import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    // ✅ Construtor padrão
    public Playlist() {
        this("Minha Playlist");
    }

    // ✅ Construtor parametrizado
    public Playlist(String nome) {
        setNome(nome);
        this.musicas = new ArrayList<>();
    }

    // ✅ Getter
    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    // ✅ Setter com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Sem nome";
        } else {
            this.nome = nome.trim();
        }
    }

    // ✅ Métodos de regra de negócio
    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public int getTotalMusicas() {
        return musicas.size();
    }
}
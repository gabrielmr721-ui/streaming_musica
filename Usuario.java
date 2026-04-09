import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private ArrayList<Playlist> playlists;

    // ✅ Construtor padrão
    public Usuario() {
        this("Usuário", "email@exemplo.com");
    }

    // ✅ Construtor parametrizado
    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
        this.playlists = new ArrayList<>();
    }

    // ✅ Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    // ✅ Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Usuário";
        } else {
            this.nome = nome.trim();
        }
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            this.email = "email@exemplo.com";
        } else {
            this.email = email.trim();
        }
    }

    // ✅ Métodos úteis
    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }
}
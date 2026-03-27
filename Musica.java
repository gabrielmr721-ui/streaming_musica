public class Musica{

    private String titulo;
    private String artista;
    private int duracao;
    private String genero;

    public Musica(String titulo, String artista, int duracao, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String formatarDuracao() {
        int minutos = duracao / 60;
        int segs = duracao % 60;
        return String.format("%d:%02d", minutos, segs);
    }
}
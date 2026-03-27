import java.util.ArrayList;
import java.util.Scanner;
 
 
/**
 * Sistema de Streaming de Música - CP1
 */
public class StreamingMusicaAluno {
    
    static ArrayList<String> titulos = new ArrayList<>();
    static ArrayList<String> artistas = new ArrayList<>();
    static ArrayList<Integer> duracoes = new ArrayList<>();
    static ArrayList<String> generos = new ArrayList<>();
    
    static final String[] GENEROS_VALIDOS = {"Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica", "Funk"};
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        adicionarMusicasTeste();
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);
        
        System.out.println("\n🎵 Obrigado por usar o Sistema de Streaming! Até logo! 🎵");
        scanner.close();
    }
    
    public static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎵 SISTEMA DE STREAMING DE MÚSICA 🎵");
        System.out.println("=".repeat(50));
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar todas as músicas");
        System.out.println("3. Buscar música por título");
        System.out.println("4. Buscar músicas por artista");
        System.out.println("5. Buscar músicas por gênero");
        System.out.println("6. Exibir estatísticas");
        System.out.println("0. Sair");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");
    }
    
    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: cadastrarMusica(); break;
            case 2: listarMusicas(); break;
            case 3: buscarPorTitulo(); break;
            case 4: buscarPorArtista(); break;
            case 5: buscarPorGenero(); break;
            case 6: exibirEstatisticas(); break;
            case 0: break;
            default: System.out.println("❌ Opção inválida! Tente novamente.");
        }
    }
    
    public static void cadastrarMusica() {
        System.out.println("\n--- CADASTRAR MÚSICA ---");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        
        if (titulo.isEmpty()) {
            System.out.println("❌ Título não pode ser vazio!");
            return;
        }
        
        System.out.print("Artista: ");
        String artista = scanner.nextLine().trim();
        
        if (artista.isEmpty()) {
            System.out.println("❌ Artista não pode ser vazio!");
            return;
        }
        
        System.out.print("Duração (em segundos): ");
        int duracao;
        
        try {
            duracao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Duração inválida!");
            return;
        }
        
        if (duracao <= 0) {
            System.out.println("❌ Duração deve ser maior que 0!");
            return;
        }
        
        System.out.println("\nGêneros disponíveis:");
        
        for (int i = 0; i < GENEROS_VALIDOS.length; i++) {
            System.out.println((i + 1) + ". " + GENEROS_VALIDOS[i]);
        }
        
        System.out.print("Escolha o gênero (1-" + GENEROS_VALIDOS.length + "): ");
        
        int opcaoGenero;
        
        try {
            opcaoGenero = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Opção inválida!");
            return;
        }
        
        if (opcaoGenero < 1 || opcaoGenero > GENEROS_VALIDOS.length) {
            System.out.println("❌ Gênero inválido!");
            return;
        }
        
        String genero = GENEROS_VALIDOS[opcaoGenero - 1];
        
        titulos.add(titulo);
        artistas.add(artista);
        duracoes.add(duracao);
        generos.add(genero);
        
        System.out.println("✅ Música cadastrada com sucesso!");
    }
    
    public static void listarMusicas() {
        System.out.println("\n--- MÚSICAS CADASTRADAS ---");
        
        if (titulos.isEmpty()) {
            System.out.println("Nenhuma música cadastrada ainda.");
            return;
        }
        
        for (int i = 0; i < titulos.size(); i++) {
            System.out.printf("%d. Título: %s | Artista: %s | Duração: %s | Gênero: %s%n",
                    (i + 1),
                    titulos.get(i),
                    artistas.get(i),
                    formatarDuracao(duracoes.get(i)),
                    generos.get(i));
        }
        
        System.out.println("\nTotal: " + titulos.size() + " música(s)");
    }
    
    public static void buscarPorTitulo() {
        System.out.println("\n--- BUSCAR POR TÍTULO ---");
        
        System.out.print("Digite o título (ou parte dele): ");
        String busca = scanner.nextLine().trim().toLowerCase();
        
        boolean encontrou = false;
        
        for (int i = 0; i < titulos.size(); i++) {
            if (titulos.get(i).toLowerCase().contains(busca)) {
                
                if (!encontrou) {
                    System.out.println("\nMúsicas encontradas:");
                    encontrou = true;
                }
                
                System.out.printf("- %s | %s | %s | %s%n",
                        titulos.get(i),
                        artistas.get(i),
                        formatarDuracao(duracoes.get(i)),
                        generos.get(i));
            }
        }
        
        if (!encontrou) {
            System.out.println("❌ Nenhuma música encontrada com esse título.");
        }
    }
    
    public static void buscarPorArtista() {
        System.out.println("\n--- BUSCAR POR ARTISTA ---");
        
        System.out.print("Digite o nome do artista (ou parte dele): ");
        String busca = scanner.nextLine().trim().toLowerCase();
        
        boolean encontrou = false;
        
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).toLowerCase().contains(busca)) {
                
                if (!encontrou) {
                    System.out.println("\nMúsicas encontradas:");
                    encontrou = true;
                }
                
                System.out.printf("- %s | %s | %s | %s%n",
                        titulos.get(i),
                        artistas.get(i),
                        formatarDuracao(duracoes.get(i)),
                        generos.get(i));
            }
        }
        
        if (!encontrou) {
            System.out.println("❌ Nenhuma música encontrada para esse artista.");
        }
    }
    
    public static void buscarPorGenero() {
        System.out.println("\n--- BUSCAR POR GÊNERO ---");
        
        System.out.println("Gêneros disponíveis:");
        
        for (int i = 0; i < GENEROS_VALIDOS.length; i++) {
            System.out.println((i + 1) + ". " + GENEROS_VALIDOS[i]);
        }
        
        System.out.print("Escolha o gênero (1-" + GENEROS_VALIDOS.length + "): ");
        
        int opcaoGenero;
        
        try {
            opcaoGenero = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Opção inválida!");
            return;
        }
        
        if (opcaoGenero < 1 || opcaoGenero > GENEROS_VALIDOS.length) {
            System.out.println("❌ Gênero inválido!");
            return;
        }
        
        String generoEscolhido = GENEROS_VALIDOS[opcaoGenero - 1];
        
        boolean encontrou = false;
        
        for (int i = 0; i < generos.size(); i++) {
            if (generos.get(i).equals(generoEscolhido)) {
                
                if (!encontrou) {
                    System.out.println("\nMúsicas encontradas:");
                    encontrou = true;
                }
                
                System.out.printf("- %s | %s | %s | %s%n",
                        titulos.get(i),
                        artistas.get(i),
                        formatarDuracao(duracoes.get(i)),
                        generos.get(i));
            }
        }
        
        if (!encontrou) {
            System.out.println("❌ Nenhuma música encontrada para esse gênero.");
        }
    }
    
    public static void exibirEstatisticas() {
        System.out.println("\n--- ESTATÍSTICAS DO SISTEMA ---");
        
        if (titulos.isEmpty()) {
            System.out.println("Nenhuma música cadastrada ainda.");
            return;
        }
        
        int totalMusicas = titulos.size();
        
        int duracaoTotal = 0;
        
        for (int duracao : duracoes) {
            duracaoTotal += duracao;
        }
        
        int duracaoMedia = duracaoTotal / totalMusicas;
        
        String generoMais = generoMaisComum();
        
        System.out.println("Total de músicas: " + totalMusicas);
        System.out.println("Duração total: " + formatarDuracao(duracaoTotal));
        System.out.println("Duração média: " + formatarDuracao(duracaoMedia));
        System.out.println("Gênero mais cadastrado: " + generoMais);
    }
    
    public static String generoMaisComum() {
        
        int[] contadores = new int[GENEROS_VALIDOS.length];
        
        for (String genero : generos) {
            for (int i = 0; i < GENEROS_VALIDOS.length; i++) {
                if (genero.equals(GENEROS_VALIDOS[i])) {
                    contadores[i]++;
                    break;
                }
            }
        }
        
        int indiceMaior = 0;
        
        for (int i = 1; i < contadores.length; i++) {
            if (contadores[i] > contadores[indiceMaior]) {
                indiceMaior = i;
            }
        }
        
        return GENEROS_VALIDOS[indiceMaior];
    }
    
    public static String formatarDuracao(int segundos) {
        int minutos = segundos / 60;
        int segs = segundos % 60;
        return String.format("%d:%02d", minutos, segs);
    }
    
    public static void adicionarMusicasTeste() {
        titulos.add("Bohemian Rhapsody");
        artistas.add("Queen");
        duracoes.add(354);
        generos.add("Rock");
        
        titulos.add("Billie Jean");
        artistas.add("Michael Jackson");
        duracoes.add(293);
        generos.add("Pop");
        
        titulos.add("Smells Like Teen Spirit");
        artistas.add("Nirvana");
        duracoes.add(301);
        generos.add("Rock");
    }
}
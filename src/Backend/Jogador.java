package Backend;

/**
 * Representa um jogador no jogo da memória.
 * Armazena nome, número de tentativas e cartas viradas.
 * Implementa {@link Comparable} para permitir ordenação pelo número de tentativas.
 */
public class Jogador{

    /** Nome do jogador */
    private String nome;

    /** Quantidade de tentativas feitas pelo jogador */
    private int tentativas;

    /** Quantidade de cartas viradas pelo jogador */
    private int cartasViradas;

    /**
     * Construtor que inicializa o jogador com nome, tentativas e cartas viradas.
     * 
     * @param nome Nome do jogador
     * @param tentativas Número de tentativas realizadas
     * @param cartasViradas Número de cartas viradas
     */
    public Jogador(String nome, int tentativas, int cartasViradas) {
        this.nome = nome;
        this.tentativas = tentativas;
        this.cartasViradas = cartasViradas;
    }

    /**
     * Construtor padrão, cria um jogador vazio.
     */
    public Jogador() {
    }

    /**
     * Obtém o nome do jogador.
     * 
     * @return Nome do jogador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o número de tentativas feitas pelo jogador.
     * 
     * @return Número de tentativas
     */
    public int getTentativas() {
        return tentativas;
    }

    /**
     * Obtém a quantidade de cartas viradas pelo jogador.
     * 
     * @return Número de cartas viradas
     */
    public int getCartasViradas() {
        return cartasViradas;
    }

    /**
     * Compara este jogador com outro com base no número de tentativas.
     * Jogadores com menos tentativas são considerados melhores (ordenados antes).
     * 
     * @param outro Outro jogador para comparar
     * @return Resultado da comparação (-1, 0 ou 1)
     */
}   
    

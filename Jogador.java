package Backend;
public class Jogador implements Comparable<Jogador> {
    private String nome;
    private int tentativas;
    private int cartasViradas;

    public Jogador(String nome, int tentativas, int cartasViradas) {
        this.nome = nome;
        this.tentativas = tentativas;
        this.cartasViradas = cartasViradas;
    }

    public String getNome() { return nome; }
    public int getTentativas() { return tentativas; }
    public int getCartasViradas() { return cartasViradas; }

    @Override
    public int compareTo(Jogador outro) {
        return Integer.compare(this.tentativas, outro.tentativas);
    }

    @Override
    public String toString() {
        return nome + " - Tentativas: " + tentativas + ", Viradas: " + cartasViradas;
    }
}
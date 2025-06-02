package Backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a pontuação (score) de um jogador no jogo,
 * com nome e número de tentativas, e métodos para
 * comparar e armazenar o placar em arquivo.
 */
public class Score implements Comparable<Score> {

    /** Nome do jogador */
    String nome;

    /** Número de tentativas feitas pelo jogador */
    int tentativas;

    /**
     * Construtor que inicializa a pontuação com nome e tentativas.
     * @param nome nome do jogador
     * @param tentativas número de tentativas do jogador
     */
    public Score(String nome, int tentativas) {
        this.nome = nome;
        this.tentativas = tentativas;
    }

    /**
     * Compara duas pontuações com base no número de tentativas.
     * @param outro outro objeto Score para comparação
     * @return valor negativo, zero ou positivo conforme esta pontuação for menor, igual ou maior
     */
    @Override
    public int compareTo(Score outro) {
        return Integer.compare(this.tentativas, outro.tentativas);
    }

    /**
     * Representação em String do objeto Score.
     * @return string formatada com nome e tentativas
     */
    @Override
    public String toString() {
        return nome + " - " + tentativas + " tentativas";
    }
    
    /**
     * Carrega a lista de scores do arquivo "placar.dat".
     * @return lista de scores carregada do arquivo, ou lista vazia se arquivo não existir
     */
    private List<Score> carregarPlacar() {
        List<Score> placar = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("placar.dat"))) {
            placar = (List<Score>) ois.readObject();
        } catch (Exception e) {
            // Arquivo ainda não existe ou erro na leitura
        }
        return placar;
    }

    /**
     * Salva a lista de scores no arquivo "placar.dat".
     * @param placar lista de scores a ser salva
     */
    private void salvarPlacar(List<Score> placar) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("placar.dat"))) {
            oos.writeObject(placar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

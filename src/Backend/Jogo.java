package Backend;

import Backend.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa o jogo da memória.
 * Gerencia o tabuleiro de cartas, seleção e lógica do jogo.
 */
public class Jogo {

    /** Número fixo de linhas do tabuleiro */
    private final int linhas = 4;

    /** Número fixo de colunas do tabuleiro */
    private final int colunas = 4;

    /** Matriz de cartas do tabuleiro */
    private Carta[][] cartas;

    /** Primeira carta selecionada em uma jogada */
    private Carta primeiraSelecionada = null;

    /** Indica se o jogo está bloqueado para novas seleções */
    private boolean bloqueado = false;

    /**
     * Construtor que inicializa o tabuleiro embaralhando e distribuindo as cartas.
     */
    public Jogo() {
        inicializarCartas();
    }

    /**
     * Retorna o número de linhas do tabuleiro.
     * @return número de linhas
     */
    public int getLinhas() {
        return linhas;
    }

    /**
     * Retorna o número de colunas do tabuleiro.
     * @return número de colunas
     */
    public int getColunas() {
        return colunas;
    }

    /**
     * Retorna a carta na posição (i, j) do tabuleiro.
     * @param i índice da linha
     * @param j índice da coluna
     * @return carta na posição especificada
     */
    public Carta getCarta(int i, int j) {
        return cartas[i][j];
    }

    /**
     * Verifica se o jogo está bloqueado para seleção de cartas.
     * @return true se estiver bloqueado, false caso contrário
     */
    public boolean estaBloqueado() {
        return bloqueado;
    }

    /**
     * Bloqueia o jogo para que não seja possível selecionar cartas.
     */
    public void bloquear() {
        bloqueado = true;
    }

    /**
     * Desbloqueia o jogo permitindo seleção de cartas.
     */
    public void desbloquear() {
        bloqueado = false;
    }

    /**
     * Seleciona uma carta na posição (i, j).
     * Revela a carta e verifica se forma par com a primeira selecionada.
     * Se formar par, mantém ambas reveladas; caso contrário, oculta ambas.
     * 
     * @param i índice da linha
     * @param j índice da coluna
     * @return true se a carta puder ser selecionada, false caso contrário
     */
    public boolean selecionar(int i, int j) {
        Carta carta = cartas[i][j];
        if (carta.isRevelada() || bloqueado) return false;

        carta.revelar();
        if (primeiraSelecionada == null) {
            primeiraSelecionada = carta;
            return true; // primeira carta revelada
        } else {
            if (primeiraSelecionada.getValor().equals(carta.getValor())) {
                primeiraSelecionada = null; // par encontrado
            } else {
                // cartas diferentes: ocultar as duas
                carta.ocultar();
                primeiraSelecionada.ocultar();
                primeiraSelecionada = null;
            }
            return true;
        }
    }

    /**
     * Verifica se todas as cartas do tabuleiro estão reveladas.
     * @return true se todas as cartas estiverem reveladas, false caso contrário
     */
    public boolean todasReveladas() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!cartas[i][j].isRevelada()) return false;
            }
        }
        return true;
    }

    /**
     * Inicializa as cartas do tabuleiro criando pares de letras e embaralhando-os.
     */
    private void inicializarCartas() {
        cartas = new Carta[linhas][colunas];
        List<String> valores = new ArrayList<>();
        for (int i = 0; i < (linhas * colunas) / 2; i++) {
            String valor = String.valueOf((char) ('A' + i));
            valores.add(valor);
            valores.add(valor);
        }
        Collections.shuffle(valores);
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cartas[i][j] = new Carta(valores.get(index++));
            }
        }
    }

    /**
     * Retorna a matriz de cartas do tabuleiro.
     * @return matriz de cartas
     */
    public Carta[][] getCartas() {
        return cartas;
    }

    /**
     * Método não implementado.
     * @throws UnsupportedOperationException se chamado
     */
    public boolean todosRevelados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

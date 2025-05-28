package Backend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tabuleiro {
    private Carta[][] cartas;
    private int linhas;
    private int colunas;

    public Tabuleiro(int linhas, int colunas) {
        if ((linhas * colunas) % 2 != 0) {
            throw new IllegalArgumentException("O número total de cartas deve ser par.");
        }

        this.linhas = linhas;
        this.colunas = colunas;
        this.cartas = new Carta[linhas][colunas];

        preencherTabuleiro();
    }

    private void preencherTabuleiro() {
        List<String> valores = new ArrayList<>();
        int pares = (linhas * colunas) / 2;

        // Gera valores em pares (por exemplo, A, B, C, ..., dependendo do tamanho)
        for (int i = 0; i < pares; i++) {
            String valor = String.valueOf((char) ('A' + i)); // A, B, C, ...
            valores.add(valor);
            valores.add(valor);
        }

        // Embaralha os valores
        Collections.shuffle(valores);

        // Preenche o tabuleiro com os valores embaralhados
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cartas[i][j] = new Carta(valores.get(index));
                index++;
            }
        }
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(cartas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Carta getCarta(int linha, int coluna) {
        return cartas[linha][coluna];
    }
    
    public boolean todasCartasReveladas() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!cartas[i][j].isRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void ocultarCartas(int l1, int c1, int l2, int c2) {
        cartas[l1][c1].ocultar();
        cartas[l2][c2].ocultar();
    }
}

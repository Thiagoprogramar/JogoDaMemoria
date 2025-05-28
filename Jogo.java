package Backend;
import javax.swing.SwingUtilities;

import InterfaceSwing.InicioJogo;

public class Jogo{
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(4, 4); // 4x4 = 16 cartas = 8 pares
        tabuleiro.imprimirTabuleiro();
        SwingUtilities.invokeLater(() -> new InicioJogo());
    }
}
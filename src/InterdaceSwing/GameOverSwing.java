package InterfaceSwing;

import javax.swing.*;

/**
 * Janela que exibe a tela de "Fim de Jogo" usando Swing.
 * Mostra uma mensagem simples parabenizando o jogador pela vitória.
 */
public class GameOverSwing extends JFrame {

    /**
     * Construtor que configura a janela do fim de jogo,
     * definindo título, tamanho, comportamento de fechamento,
     * adicionando uma mensagem centralizada e tornando a janela visível.
     */
    public GameOverSwing() {
        setTitle("Fim de Jogo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Parabéns! Você venceu!", SwingConstants.CENTER));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

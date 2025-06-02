package InterfaceSwing;

import Backend.Carta;
import Backend.Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interface gráfica do jogo da memória utilizando Swing.
 * Controla a interação do jogador com o tabuleiro e exibe o número de tentativas.
 */
public class JogoSwing extends JFrame {

    private final Jogo jogo;
    private final JButton[][] botoes;
    private int tentativas = 0;
    private JLabel labelTentativas;
    private boolean bloqueado = false;
    private Carta primeiraSelecionada = null;
    private JButton botaoPrimeiro = null;

    /**
     * Construtor que inicializa a janela do jogo,
     * configurando o layout, criando o tabuleiro de botões e exibindo o contador de tentativas.
     */
    public JogoSwing() {
        jogo = new Jogo();
        botoes = new JButton[jogo.getLinhas()][jogo.getColunas()];

        setTitle("Jogo da Memória");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        labelTentativas = new JLabel("Tentativas: 0");
        labelTentativas.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelTentativas, BorderLayout.NORTH);

        JPanel painelCartas = new JPanel(new GridLayout(jogo.getLinhas(), jogo.getColunas()));
        for (int i = 0; i < jogo.getLinhas(); i++) {
            for (int j = 0; j < jogo.getColunas(); j++) {
                JButton botao = new JButton("?");
                botoes[i][j] = botao;
                int finalI = i;
                int finalJ = j;

                botao.addActionListener(e -> selecionarCarta(finalI, finalJ, botao));
                painelCartas.add(botao);
            }
        }

        add(painelCartas, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Incrementa o contador de tentativas e atualiza o rótulo na interface.
     */
    private void incrementarTentativas() {
        tentativas++;
        labelTentativas.setText("Tentativas: " + tentativas);
    }

    /**
     * Lida com a seleção de uma carta pelo jogador.
     * Revela a carta selecionada, compara com a primeira carta selecionada (se houver),
     * e gerencia o bloqueio da interface enquanto aguarda a verificação.
     * 
     * @param i índice da linha da carta selecionada
     * @param j índice da coluna da carta selecionada
     * @param botao botão correspondente à carta selecionada na interface gráfica
     */
    private void selecionarCarta(int i, int j, JButton botao) {
        if (bloqueado) return;

        Carta carta = jogo.getCarta(i, j);
        if (carta.isRevelada()) return;

        carta.revelar();
        botao.setText(carta.getValor());

        if (primeiraSelecionada == null) {
            primeiraSelecionada = carta;
            botaoPrimeiro = botao;
        } else {
            incrementarTentativas();
            bloqueado = true;

            Carta segundaSelecionada = carta;
            JButton botaoSegundo = botao;

            Timer timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!primeiraSelecionada.getValor().equals(segundaSelecionada.getValor())) {
                        primeiraSelecionada.ocultar();
                        segundaSelecionada.ocultar();
                        botaoPrimeiro.setText("?");
                        botaoSegundo.setText("?");
                    }

                    primeiraSelecionada = null;
                    botaoPrimeiro = null;
                    bloqueado = false;

                    if (jogo.todosRevelados()) {
                        dispose();
                        new GameOverSwing(); // Exibe tela de fim de jogo
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}

package InterfaceSwing;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.*;
	

	public class JogoSwing extends JFrame {
	    private final int linhas = 4;
	    private final int colunas = 4;
	    private Carta[][] cartas;
	    private JButton[][] botoes;
	    private Carta primeiraSelecionada = null;
	    private JButton botaoPrimeiro = null;
	    private boolean bloqueado = false;

	    public JogoSwing() {
	        setTitle("Jogo da Memória");
	        setSize(600, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(linhas, colunas));

	        inicializarJogo();
	    }

	    private void inicializarJogo() {
	        cartas = new Carta[linhas][colunas];
	        botoes = new JButton[linhas][colunas];
	        List<String> valores = gerarValoresCartas();

	        Collections.shuffle(valores);
	        int index = 0;

	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                String valor = valores.get(index++);
	                cartas[i][j] = new Carta(valor);
	                JButton botao = new JButton("?");
	                botoes[i][j] = botao;
	                int finalI = i;
	                int finalJ = j;

	                botao.addActionListener(e -> selecionarCarta(finalI, finalJ, botao));
	                add(botao);
	            }
	        }
	    }

	    private List<String> gerarValoresCartas() {
	        List<String> valores = new ArrayList<>();
	        for (int i = 0; i < (linhas * colunas) / 2; i++) {
	            String valor = String.valueOf((char) ('A' + i));
	            valores.add(valor);
	            valores.add(valor);
	        }
	        return valores;
	    }

	    private void selecionarCarta(int i, int j, JButton botao) {
	        if (bloqueado) return;

	        Carta carta = cartas[i][j];
	        if (carta.isRevelada()) return;

	        carta.revelar();
	        botao.setText(carta.getValor());

	        if (primeiraSelecionada == null) {
	            primeiraSelecionada = carta;
	            botaoPrimeiro = botao;
	        } else {
	            bloqueado = true;

	            Timer timer = new Timer(1000, new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    if (primeiraSelecionada.getValor().equals(carta.getValor())) {
	                        primeiraSelecionada.revelar();
	                        carta.revelar();
	                    } else {
	                        primeiraSelecionada.ocultar();
	                        carta.ocultar();
	                        botaoPrimeiro.setText("?");
	                        botao.setText("?");
	                    }
	                    primeiraSelecionada = null;
	                    botaoPrimeiro = null;
	                    bloqueado = false;

	                    if (todasReveladas()) {
	                    	dispose(); // fecha o jogo
	                    	new GameOver(); // mostra tela final
	                    }
	                }
	            });
	            timer.setRepeats(false);
	            timer.start();
	        }
	    }

	    private boolean todasReveladas() {
	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                if (!cartas[i][j].isRevelada()) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new JogoSwing().setVisible(true);
	        });
	    }
	}


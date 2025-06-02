/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A janela que exibe a tela de "Game Over" ao final do jogo da memória.
 * Mostra o ranking com os 10 melhores jogadores e salva o resultado do jogador atual.
 * 
 * <p>Esta classe utiliza {@link Ranking} para carregar e salvar o ranking
 * e exibe os dados em uma {@link JTextArea} com rolagem.</p>
 * 
 * @author SeuNome
 */
public class GameOver extends JFrame {

    /**
     * Cria uma nova janela de "Game Over", salvando o jogador atual
     * no ranking e exibindo os 10 melhores placares.
     *
     * @param jogadorAtual o jogador que acabou de jogar
     */
    public GameOver(Jogador jogadorAtual) {
        setTitle("Game Over");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Salva e carrega o ranking
        Ranking.salvar(jogadorAtual);
        List<Jogador> ranking = Ranking.carregar();

        // Cria a área de texto com o ranking
        JTextArea area = new JTextArea();
        area.setEditable(false);
        StringBuilder sb = new StringBuilder("🏆 Top 10 Melhores Placares:\n\n");
        for (int i = 0; i < ranking.size(); i++) {
            sb.append((i + 1)).append(". ").append(ranking.get(i).toString()).append("\n");
        }

        area.setText(sb.toString());
        add(new JScrollPane(area));
        setVisible(true);
    }
}

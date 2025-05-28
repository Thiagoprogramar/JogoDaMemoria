package InterfaceSwing;

import javax.swing.*;

import Backend.Jogador;
import Backend.Ranking;

import java.awt.*;
import java.awt.event.*;


public class GameOver extends JFrame {
    public GameOver(Jogador jogadorAtual) {
        setTitle("Game Over");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Ranking.salvar(jogadorAtual);
        List<Jogador> ranking = Ranking.carregar();

        JTextArea area = new JTextArea();
        area.setEditable(false);
        StringBuilder sb = new StringBuilder("🏆 Top 10 Melhores Placares:\n\n");
        for (int i = 0; i < ranking.size(); i++) {
            sb.append((i + 1) + ". " + ranking.get(i).toString() + "\n");
        }

        area.setText(sb.toString());
        add(new JScrollPane(area));
        setVisible(true);
    }
}
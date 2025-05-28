package InterfaceSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InicioJogo extends JFrame {
    public InicioJogo() {
        setTitle("Jogo da Memória - Início");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton iniciarBtn = new JButton("Iniciar Jogo");
        iniciarBtn.addActionListener(e -> {
            dispose(); // fecha a tela de início
            new InicioJogo(); // abre o jogo
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Bem-vindo ao Jogo da Memória!", SwingConstants.CENTER), BorderLayout.CENTER);
        panel.add(iniciarBtn, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
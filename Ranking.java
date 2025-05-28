package Backend;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
    private static final String ARQUIVO = "placares.txt";

    public static void salvar(Jogador jogador) {
        List<Jogador> lista = carregar();
        lista.add(jogador);
        Collections.sort(lista);
        if (lista.size() > 10) lista = lista.subList(0, 10);

        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Jogador j : lista) {
                writer.println(j.getNome() + ";" + j.getTentativas() + ";" + j.getCartasViradas());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Jogador> carregar() {
        List<Jogador> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String nome = partes[0];
                    int tentativas = Integer.parseInt(partes[1]);
                    int viradas = Integer.parseInt(partes[2]);
                    lista.add(new Jogador(nome, tentativas, viradas));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
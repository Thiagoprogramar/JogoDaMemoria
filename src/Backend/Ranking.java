package Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável por salvar e carregar o ranking dos jogadores em um arquivo texto.
 * O ranking mantém os 10 melhores jogadores, ordenados pelo menor número de tentativas.
 */
public class Ranking {

    private static final String ARQUIVO = "placares.txt";

    /**
     * Salva um jogador no ranking, ordenando a lista por tentativas e mantendo os 10 melhores.
     * 
     * @param jogador O jogador a ser salvo no ranking.
     */
    public static void salvar(Jogador jogador) {
        List<Jogador> lista = carregar();
        lista.add(jogador);
        // Ordena a lista pelo número de tentativas (menor para maior)
        Collections.sort(lista, Comparator.comparingInt(Jogador::getTentativas));
        if (lista.size() > 10) {
            lista = lista.subList(0, 10);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Jogador j : lista) {
                writer.println(j.getNome() + ";" + j.getTentativas() + ";" + j.getCartasViradas());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega a lista de jogadores do arquivo de ranking.
     * Se o arquivo não existir, retorna uma lista vazia.
     * 
     * @return Lista com os jogadores carregados do arquivo.
     */
    public static List<Jogador> carregar() {
        List<Jogador> lista = new ArrayList<>();
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return lista;
        }

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

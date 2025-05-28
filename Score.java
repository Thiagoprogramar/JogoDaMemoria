package Backend;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Score implements Comparable<Score> {
    String nome;
    int tentativas;

    public Score(String nome, int tentativas) {
        this.nome = nome;
        this.tentativas = tentativas;
    }

    @Override
    public int compareTo(Score outro) {
        return Integer.compare(this.tentativas, outro.tentativas);
    }

    @Override
    public String toString() {
        return nome + " - " + tentativas + " tentativas";
    }
    
    private List<Score> carregarPlacar() {
        List<Score> placar = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("placar.dat"))) {
            placar = (List<Score>) ois.readObject();
        } catch (Exception e) {
            // Arquivo ainda não existe
        }
        return placar;
    }

    private void salvarPlacar(List<Score> placar) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("placar.dat"))) {
            oos.writeObject(placar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
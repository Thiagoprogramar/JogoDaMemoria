package Backend;

public class Carta {
	private String valor;     // Pode ser uma letra, número, emoji, etc.
    private boolean revelada; // Controla se a carta está visível ou oculta

    public Carta(String valor) {
        this.valor = valor;
        this.revelada = false;
    }

    public String getValor() {
        return valor;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void revelar() {
        this.revelada = true;
    }

    public void ocultar() {
        this.revelada = false;
    }

    @Override
    public String toString() {
        return revelada ? valor : "X";
    }
}

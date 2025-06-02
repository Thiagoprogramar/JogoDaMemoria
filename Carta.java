/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 * Representa uma carta do jogo da memória.
 * Cada carta possui um valor (como letra, número ou emoji) e um estado revelado/oculto.
 */
public class Carta {
    private String valor;     // Pode ser uma letra, número, emoji, etc.
    private boolean revelada; // Controla se a carta está visível ou oculta

    /**
     * Cria uma nova carta com o valor fornecido e oculta por padrão.
     *
     * @param valor o valor da carta (ex: "A", "1", "😀")
     */
    public Carta(String valor) {
        this.valor = valor;
        this.revelada = false;
    }

    /**
     * Retorna o valor da carta.
     *
     * @return o valor da carta
     */
    public String getValor() {
        return valor;
    }

    /**
     * Verifica se a carta está revelada.
     *
     * @return true se a carta estiver revelada, false se estiver oculta
     */
    public boolean isRevelada() {
        return revelada;
    }

    /**
     * Revela a carta, tornando seu valor visível.
     */
    public void revelar() {
        this.revelada = true;
    }

    /**
     * Oculta a carta, escondendo seu valor.
     */
    public void ocultar() {
        this.revelada = false;
    }

    /**
     * Retorna uma representação textual da carta.
     * Se estiver revelada, mostra seu valor. Caso contrário, mostra "X".
     *
     * @return representação da carta
     */
    @Override
    public String toString() {
        return revelada ? valor : "X";
    }
}

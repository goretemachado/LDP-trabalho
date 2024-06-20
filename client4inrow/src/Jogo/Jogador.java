// A classe possui dois atributos nome e cor, ambos privados.

package Jogo;

public class Jogador {

    // Atributos do Jogador onde armazenará o nome e a cor do jogador.
    private String nome;
    private String cor;

    // Metodo que retorna o nome do jogador
    public String getName() {
        return nome;
    }

    // Metodo que define o nome do jogador
    public void setName(String name) {
        this.nome = name;// Define o nome do jogador
    }

    // Metodo que retorna o nome do jogador
    public String getColor() {
        return cor;
    }

    // Metodo que define a cor do jogador
    public void setColor(String cor) {
        this.cor = cor;// Define a cor do jogador
    }
}

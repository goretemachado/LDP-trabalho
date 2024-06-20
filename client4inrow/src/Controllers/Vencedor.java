// O controlador Vencedor gerencia a interface que exibe o resultado do
// vencedor em uma aplicação JavaFX.

package Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Vencedor {
    @FXML
    private Label LabelVencedor;

    // Método para receber e definir a cor do vencedor
    public void receberDados(String nomeVencedor, String corVencedor) {
        // Definir o texto da label com a cor do vencedor
        LabelVencedor.setText(corVencedor + " VENCEU!");
    }

    // Método para fechar a aplicação
    @FXML
    public void Sair(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close(); // Fechar a janela atual da VencedorTela
        Platform.exit(); // Fechar a aplicação completamente
    }
}

package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Empate {
    @FXML
    private Label empateLabel;

    @FXML
    private Button okButton;

    // Método para configurar a mensagem de empate
    public void setEmpate() {
        empateLabel.setText("Empate!");
    }

    // Método para fechar a aplicação
    @FXML
    private void OK() {
        // Obtém a janela atual (stage) a partir do botão
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}

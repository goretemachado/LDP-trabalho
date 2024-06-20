// O controlador Empate é responsável por exibir uma mensagem de empate e
// permitir que o utilizador feche a aplicação ao clicar em um botão.

package Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Empate {
    @FXML
    private Label LabelEmpate;

    // Método para receber e definir a mensagem de empate
    public void receberDadosEmpate(String mensagemEmpate) {
        // Definir o texto da label com a mensagem de empate
        LabelEmpate.setText(mensagemEmpate);
    }

    // Método para fechar a aplicação
    @FXML
    public void Sair(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close(); // Fechar a janela atual da VencedorTela
        Platform.exit(); // Fechar a aplicação completamente
    }
}

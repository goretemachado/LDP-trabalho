// O controlador PrimeiraTela é a primeira tela que vai abrir do jogo,
// permitindo a transição para a segunda tela ou o encerramento da aplicação.

package Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimeiraTela {

    // Este método é invocado quando ocorre um evento ActionEvent, tipicamente associado
    // a um botão ou outra interação do utilizador para avançar para a próxima tela
    public void ProximaPagina(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da Segunda Tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SegundaTela.fxml"));
            Parent root = loader.load();

            // Criar um novo Stage para exibir a Segunda Tela
            Stage stage = new Stage();
            stage.setTitle("Cliente Tela");// Definir o título da janela da Segunda Tela
            stage.setScene(new Scene(root, 800, 600)); // Definir a cena com o conteúdo da Segunda Tela
            stage.show();

            // Fechar a janela atual da primeira tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método é invocado quando ocorre um evento ActionEvent, geralmente associado
    // a um botão ou evento para fechar a aplicação.
    public void Sair(ActionEvent actionEvent) {
        // Fechar a janela atual (Stage)
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Platform.exit();// Fechar a aplicação completamente
    }
}

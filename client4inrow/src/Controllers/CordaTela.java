// O controlador CordaTela permite que o utilizador selecione uma cor (amarelo
// ou vermelho) e, ao clicar em um botão de "voltar", abre uma nova tela (SegundaTela)
// passando a cor selecionada para esta nova tela. Ele ajusta visualmente os botões
// para indicar qual cor está selecionada.

package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CordaTela {

    // armazena a cor selecionada pelo utilizador
    private String corSelecionada;

    @FXML
    // componentes definidos no arquivo FXML
    Button BtnAmarelo,BtnVermelho;

    public void initialize(){
        // Define a cor inicial como amarelo
        corSelecionada="FFFF00FF";
    }

    public void Voltar(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da Segunda Tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SegundaTela.fxml"));
            Parent root = loader.load();

            // Obter o controlador da Segunda Tela
            SegundaTela controller = loader.getController();
            // Envia a corSelecionada para a Segunda Tela
            controller.receberCorSelecionada(corSelecionada);

            // Criar um novo Stage para exibir a Segunda Tela
            Stage stage = new Stage();
            stage.setTitle("Server");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();

            // Fechar a janela atual da tela de seleção de cor
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Método chamado quando o botão "Amarelo" é clicado para escolher a Cor Amarelo
    public void EscolherAmarelo(ActionEvent actionEvent) {
        // Define a corSelecionada como Amarelo
        corSelecionada = "#FFFF00FF";
        // Coloca a Borda do botão Amarelo maior
        BtnAmarelo.setStyle("-fx-background-radius:100;-fx-background-color: #ffff00;-fx-border-color:#000000;-fx-border-radius:100;-fx-border-width:5");
        // Coloca a Borda do botão Vermelho menor
        BtnVermelho.setStyle("-fx-background-radius:100;-fx-background-color: #ff0000;-fx-border-color:#000000;-fx-border-radius:100;-fx-border-width:0");
    }

    // Método chamado quando o botão "Vermelho" é clicado para escolher a Cor Vermelha
    public void EscolherVermelho(ActionEvent actionEvent) {
        // Define a corSelecionada como Vermelha
        corSelecionada = "#FF0000FF";
        // Coloca a Borda do botão Vermelho maior
        BtnVermelho.setStyle("-fx-background-radius:100;-fx-background-color: #ff0000;-fx-border-color:#000000;-fx-border-radius:100;-fx-border-width:5");
        // Coloca a Borda do botão Amarelo menor
        BtnAmarelo.setStyle("-fx-background-radius:100;-fx-background-color: #ffff00;-fx-border-color:#000000;-fx-border-radius:100;-fx-border-width:0");
    }
}

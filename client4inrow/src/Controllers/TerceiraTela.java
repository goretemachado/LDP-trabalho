// A classe TerceiraTela coordena a transição entre telas da aplicação JavaFX,
// carregando dinamicamente os arquivos FXML das telas (SegundaTela.fxml e JogoTela.fxml),
// passando dados entre controladores (SegundaTela e TeladeJogo).

package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class TerceiraTela {

    // permitem ao utilizador inserir texto.
    @FXML
    private TextField TxtIP;
    @FXML
    private TextField TxtNome;

    // utilizado para exibir texto na interface gráfica.
    @FXML
    private Label TextoLabel;

    // Variável que armazena a cor selecionada na SegundaTela e será utilizada para
    // configurar o texto do Label na interface gráfica.
    private String corSelecionada;

    // Método chamado quando o utilizador clica no botão "Voltar".
    // Ele carrega o arquivo FXML da SegundaTela.
    public void Voltar(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da Segunda Tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SegundaTela.fxml"));
            Parent root = loader.load();

            // Criar um novo Stage para exibir a Segunda Tela
            Stage stage = new Stage();
            stage.setTitle("Segunda Tela");// Definir o título da janela da Segunda Tela
            stage.setScene(new Scene(root, 800, 600));// Definir a cena com o conteúdo da Segunda Tela
            stage.show();

            // Fechar a janela atual da Terceira Tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método acionado quando o utilizador clica no botão que leva à JogoTela.
    // Ele carrega o arquivo FXML da JogoTela.
    public void TelaJogo(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da JogoTela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/JogoTela.fxml"));
            Parent root = loader.load();

            // Obter o controlador da JogoTela
            TeladeJogo controller = loader.getController();
            controller.receberDadosJogo(TxtNome.getText(), TxtIP.getText(),corSelecionada); // Passar o nome, endereço IP e cor selecionada para a JogoTela

            // Criar um novo Stage para exibir a JogoTela
            Stage stage = new Stage();
            stage.setTitle("Cliente Tela");// Definir o título da janela da JogoTela
            stage.setScene(new Scene(root, 800, 600));// Definir a cena com o conteúdo da JogoTela
            stage.show();

            // Fechar a janela atual da terceira tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método utilizado para receber a cor selecionada na SegundaTela.
    public void receberCorSelecionada(String cor) {
        // Recebe corSelecionada proveniente da SegundaTela
        corSelecionada = cor;
        // Definir a cor do texto da label com base na cor selecionada
        TextoLabel.setTextFill(Color.web(corSelecionada));
    }
}

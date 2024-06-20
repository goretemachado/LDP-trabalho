// O controlador SegundaTela, aqui tem um botao onde levará para a CordaTela
// e depois de a cor estar selecionada levará para a TerceiraTela para avançar.

package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SegundaTela {

    // armazena a cor selecionada pelo utilizador
    private String corSelecionada;

    // Um botão que será visível ou não, dependendo se uma cor foi selecionada.
    @FXML
    private Button BtnLigar;

    //Inica a pagina sem o Botao de Ligar
    public void initialize(){
        BtnLigar.setVisible(false);

    }

    // Este método é chamado quando o utilizador seleciona a opção de escolher uma cor.
    public void EscolherCor(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da tela de seleção de cor
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/CorTela.fxml"));
            Parent root = loader.load();

            // Criar um novo Stage para exibir a tela de seleção de cor
            Stage stage = new Stage();
            stage.setTitle("Seleção de Cor Client");// Definir o título da janela da tela de seleção de cor
            stage.setScene(new Scene(root, 800, 600));// Definir a cena com o conteúdo da tela de seleção de cor
            stage.show();

            // Fechar a janela atual da Segunda Tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método é invocado quando o utilizador avança para a próxima tela após
    // selecionar uma cor.
    public void ProximaPagina(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da Terceira Tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/TerceiraTela.fxml"));
            Parent root = loader.load();

            // Obter o controlador da Terceira Tela
            TerceiraTela controller = loader.getController();
            //Envia a corSelecionada para a Terceira Tela
            controller.receberCorSelecionada(corSelecionada);

            // Criar um novo Stage para exibir a Terceira Tela
            Stage stage = new Stage();
            stage.setTitle("Cliente Tela");// Definir o título da janela da Terceira Tela
            stage.setScene(new Scene(root, 800, 600));// Definir a cena com o conteúdo da Terceira Tela
            stage.show();

            // Fechar a janela atual da Segunda Tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método é acionado quando o utilizador deseja voltar para a primeira tela.
    public void Voltar(ActionEvent actionEvent) {
        try {
            // Carregar o arquivo FXML da Primeira Tela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/PrimeiraTela.fxml"));
            Parent root = loader.load();

            // Criar um novo Stage para exibir a Primeira Tela
            Stage stage = new Stage();
            stage.setTitle("Cliente Tela");// Definir o título da janela da Primeira Tela
            stage.setScene(new Scene(root, 800, 600));// Definir a cena com o conteúdo da Primeira Tela
            stage.show();

            // Fechar a janela atual da Segunda Tela
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Este método verifica se corSelecionada possui um valor.
    public void btnJogarVisibel(){
        if (corSelecionada== null){
            // Tornar o botão BtnLigar invisível se a cor não tiver sido selecionada
            BtnLigar.setVisible(false);
        }else {
            // Tornar o botão BtnLigar visível se a cor tiver sido selecionada
            BtnLigar.setVisible(true);
        }
    }

    // Este método é chamado pela CorTela para enviar a cor selecionada para a SegundaTela.
    public void receberCorSelecionada(String cor) {
        // Definir a cor do texto da label com base na cor selecionada(CorTela)
        corSelecionada = cor;
        // Atualizar a visibilidade do botão BtnLigar
        btnJogarVisibel();
    }
}

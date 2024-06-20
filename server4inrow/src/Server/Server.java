// Este código implementa um servidor para um jogo que escuta conexões de clientes,
// envia e recebe mensagens, e manipula a interface gráfica de acordo com as
// mensagens recebidas.

package Server;

import Controllers.TeladeJogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // Para escutar e aceitar conexões de clientes.
    private ServerSocket servidorSocket;

    // Para a conexão com o cliente.
    private Socket socket;

    // Para enviar mensagens ao cliente.
    private PrintWriter out;

    // Para receber mensagens do cliente.
    private BufferedReader in;

    // Referência ao controlador da tela do jogo (TeladeJogo).
    private TeladeJogo TeladeJogo;

    // Construtor - Inicializa a variável TeladeJogo com a instância passada.
    public Server(TeladeJogo TeladeJogo){
        this.TeladeJogo = TeladeJogo;
    }

    // Metodo que cria uma nova instância de ServerSocket na porta 8888 para aguardar a
    // conexão de um cliente
    public void iniciarServidor() {
        //Cria uma Thread para o Servidor
        Thread serverThread = new Thread(() -> {
            try {
                //Define a porta do Servidor
                servidorSocket = new ServerSocket(8888);
                System.out.println("Servidor iniciado. Aguardando conexão do cliente...");
                while (true) {
                    socket = servidorSocket.accept();// Aguardar a conexão de um cliente
                    System.out.println("Cliente conectado: " + socket.getInetAddress());// Exibir o endereço IP do cliente conectado
                    out = new PrintWriter(socket.getOutputStream(), true);//Cria um objeto para enviar Mensagens
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// Cria um objeto para receber Mensagens
                    TeladeJogo.enviarNomeP();// Chamar o método enviarNomeP() da JogoTela para enviar o nome do primeiro jogador
                    receberMensagens();// Iniciar a receção de mensagens do cliente numa nova Thread
                    new Thread(this::receberMensagens).start(); //Nova Thread para as mensagens
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serverThread.start();// Iniciar a Thread do servidor

    }

    // Metodo para enviar Mensagem para o CLiente
    public void enviarMensagem(String mensagem) {
        if (out != null) {
            out.println(mensagem);// Enviar a mensagem para o cliente conectado
        }
    }

    // Metodo para Receber Mensagens do Cliente
    private void receberMensagens() {
        try {
            String mensagem;

            // LOOP - Enquanto o Socket estiver conectado as mensagens são lidas no loop
            while (socket.isConnected() && (mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
                //Restrições para as mensagens lidas
                if(mensagem.equals("0")||mensagem.equals("1")||mensagem.equals("2")||mensagem.equals("3")||mensagem.equals("4")||mensagem.equals("5")||mensagem.equals("6") ){
                    TeladeJogo.handleButtonClick(Integer.parseInt(mensagem));// Chamar o método handleButtonClick() da JogoTela para tratar o botão clicado pelo cliente
                }else if(mensagem.equals("Desistiu")){
                    TeladeJogo.SegundoPlayerDesistir();// Chamar o método SegundoPlayerDesistir() da JogoTela caso o segundo jogador desista
                }else{
                    TeladeJogo.segundoPLayer(mensagem);// Chamar o método segundoPLayer() da JogoTela para tratar a mensagem recebida do cliente
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

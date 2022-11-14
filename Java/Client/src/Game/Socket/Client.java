package Game.Socket;

import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {
    private Socket client;
    private DataOutputStream output; // Enviar mensajes
    private BufferedInputStream input; // Recibir mensajes
    private ClientReader reader;
    private ClientSender sender;

    public void startClient(int port) throws IOException {
        this.client = new Socket("localhost", port);
        System.out.println("Se ha conectado");

        this.input = new BufferedInputStream(client.getInputStream());
        this.output = new DataOutputStream(client.getOutputStream());

        this.reader = new ClientReader(this.input);
        new Thread(this.reader).start();

        this.sender = new ClientSender(this.output);
    }

    public void sendMessage(String message) throws IOException {
        this.sender.send(message);
    }

}

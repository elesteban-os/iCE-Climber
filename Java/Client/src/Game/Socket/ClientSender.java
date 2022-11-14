package Game.Socket;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClientSender {
    private DataOutputStream output;

    public ClientSender(DataOutputStream output) {
        this.output = output;
    }

    public void send(String message) throws IOException {
        this.output.writeBytes(message);
    }
}

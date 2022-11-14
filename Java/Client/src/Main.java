import java.util.Scanner;

import Game.Socket.Client;

public class Main {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.startClient(1337);

        // Scanner de ejemplo
        Scanner scanner = new Scanner(System.in);
        String message;
        while(true) {
            message = scanner.nextLine();
            client.sendMessage(message);
            client.sendMessage("!");
        }
    }
}

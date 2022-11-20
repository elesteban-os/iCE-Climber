package Game.Socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ClientReader implements Runnable {
    private BufferedInputStream input;
    private byte byteBuffer[] = new byte[1024];
    private String message;
    private Interpreter interpreter = new Interpreter();
    private int actions[];
    
    public ClientReader(BufferedInputStream input){
        this.input = input;
    }

    public void readMessages() {
        while(true) {
            try{
                input.read(byteBuffer);
                message = new String(byteBuffer);
                actions = interpreter.readMessage(message);
                System.out.println(message);
                Arrays.fill(byteBuffer, (byte)0); 
            } catch (IOException io){
                System.out.println("No se pudo leer el texto.");
            }
        }
    }

    public void run() {
        readMessages();
    }
}
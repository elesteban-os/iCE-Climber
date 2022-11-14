package Game.Socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ClientReader implements Runnable {
    private BufferedInputStream input;
    byte byteBuffer[] = new byte[1024];
    String message;
    
    public ClientReader(BufferedInputStream input){
        this.input = input;
    }

    public void readMessages() {
        while(true) {
            try{
                input.read(byteBuffer);
                message = new String(byteBuffer);
            } catch (IOException io){
                System.out.println("No se pudo leer el texto.");
            }
    
            System.out.println(message);
            Arrays.fill(byteBuffer, (byte)0); 
        }
    }

    public void run() {
        readMessages();
    }
}
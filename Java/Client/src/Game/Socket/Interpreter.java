package Game.Socket;
import java.util.StringTokenizer;

public class Interpreter {
    private int actions[] = new int[6];
    private int noActions = 0;
    int accion0 = 0;
    int arg1 = 0;
    int arg2 = 0;

    public int[] readMessage(String message) {
        StringTokenizer st = new StringTokenizer(message, ",");
        int i = 0;        
        while (st.hasMoreTokens()) {
            actions[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        noActions = i;
        return this.actions;
    }

    public void action(int actions[]) {
        switch(actions[0]) {
            case 1 -> {
                arg1 = actions[1];
                arg2 = actions[2];
                switch(arg1) {
                    case 1 -> {
                        System.out.println("Enemigo: " + "Foca" + " en piso: " + arg2);
                        break;
                    }
                    case 2 -> {
                        System.out.println("Enemigo: " + "Ave" + " en piso: " + arg2);
                        break;
                    }
                    case 3 -> {
                        System.out.println("Enemigo: " + "Hielo" + " en piso: " + arg2);
                        break;
                    }
                    
                }                
                break;
            } 
            case 2 -> {
                arg1 = actions[1];
                switch(arg1) {
                    case 1 -> {
                        System.out.println("Fruta: " + "Naranja");
                        break;
                    }
                    case 2 -> {
                        System.out.println("Fruta: " + "Banano");
                        break;
                    }
                    case 3 -> {
                        System.out.println("Fruta: " + "Berenjena");
                        break;
                    }
                    case 4 -> {
                        System.out.println("Fruta: " + "Lechuga");
                        break;
                    }
                    
                }                
                break;
            } 
            case 3 -> {
                // Movimiento de los personajes
            }
        }
    } 

    public int[] getActions() {
        return actions;
    }

    

}

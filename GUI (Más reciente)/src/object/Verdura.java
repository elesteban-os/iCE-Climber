package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Verdura extends SuperObject{

    public Verdura(){
        name = "VerduraUno";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fruta1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

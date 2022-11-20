package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class VerduraCuatro extends SuperObject{

    public VerduraCuatro(){
        name = "VerduraCuatro";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fruta4.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

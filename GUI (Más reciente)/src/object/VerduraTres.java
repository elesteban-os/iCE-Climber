package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class VerduraTres extends SuperObject{

    public VerduraTres(){
        name = "VerduraTres";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fruta3.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


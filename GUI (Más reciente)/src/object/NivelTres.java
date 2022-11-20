package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelTres extends SuperObject{

    public NivelTres(){
        name = "Tres";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Brick.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

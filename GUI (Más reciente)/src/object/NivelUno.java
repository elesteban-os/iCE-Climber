package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelUno extends SuperObject{

    public NivelUno(){
        name = "Uno";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

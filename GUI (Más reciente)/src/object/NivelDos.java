package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelDos extends SuperObject{

    public NivelDos(){
        name = "Dos";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak 2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

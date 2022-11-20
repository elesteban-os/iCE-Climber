package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelCuatro extends SuperObject{

    public NivelCuatro(){
        name = "Cuatro";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wood.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

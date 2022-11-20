package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelCinco extends SuperObject{

    public NivelCinco(){
        name = "Cinco";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

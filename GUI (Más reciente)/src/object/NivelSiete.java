package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelSiete extends SuperObject{

    public NivelSiete(){
        name = "Siete";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Brick.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

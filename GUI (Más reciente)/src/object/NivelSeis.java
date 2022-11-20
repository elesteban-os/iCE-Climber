package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelSeis extends SuperObject{

    public NivelSeis(){
        name = "Seis";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/IceBreak 2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

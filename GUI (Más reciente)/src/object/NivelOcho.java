package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NivelOcho extends SuperObject{

    public NivelOcho(){
        name = "Seis";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wood.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

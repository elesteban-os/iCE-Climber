package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class VerduraDos extends SuperObject{

    public VerduraDos(){
        name = "VerduraDos";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fruta2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

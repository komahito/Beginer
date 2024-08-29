package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots () {
        name = "Boots";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/boots.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));
    }
}

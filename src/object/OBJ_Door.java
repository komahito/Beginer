package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {

    public OBJ_Door () {
        name = "Door";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

        collision = true;
    }
    
}

package object;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Key extends SuperObject {
    public OBJ_Key () {
        name = "Key";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/key.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));
    }
}
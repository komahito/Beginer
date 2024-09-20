package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

import entity.Player;

public class OBJ_HouseDoor extends SuperObject {

    public OBJ_HouseDoor (GamePanel gp) {
        this.gp = gp;
        name = "HouseDoor";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

        collision = false;
        disappear = false;
    }

    public void interacted (Player player) {
        gp.tileM.changeMap(0);
    }
    
}

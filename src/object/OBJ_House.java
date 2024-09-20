package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;
import tile.TileManager;

public class OBJ_House extends SuperObject {
    GamePanel gp;

    public OBJ_House (GamePanel gp) {
        this.gp = gp;
        collision = true;
        disappear = false;

        name = "House";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/house.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void interacted (Player player) {
        gp.tileM.changeMap(1);
    }
}
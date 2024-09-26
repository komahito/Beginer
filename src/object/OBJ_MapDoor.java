package object;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import entity.Player;
import main.ChangeWorld;
import tile.Map;

public class OBJ_MapDoor extends SuperObject {
    public int adjX;
    public int adjY;

    public Map frontMap;
    public Map backMap;

    public OBJ_MapDoor (GamePanel gp) {
        this.gp = gp;
        name = "MapDoor";
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
        if (frontMap != null) gp.cWorld.changeMapFlag(frontMap.mapNum);
    }
}

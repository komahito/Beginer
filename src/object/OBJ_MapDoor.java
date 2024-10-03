package object;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import entity.Player;
import main.ChangeWorld;
import tile.Map;

public class OBJ_MapDoor extends SuperObject implements EnterKey, NeedKey {
    public int adjX;
    public int adjY;

    public Map frontMap;
    public Map backMap;

    public int keyNum = 0;
    boolean isLocked = false;

    public OBJ_MapDoor (GamePanel gp) {
        this.gp = gp;
        name = "MapDoor";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

        collision = true;
        disappear = false;
    }

    public boolean checkIsLocked () {
        return isLocked;
    }
    public void setKey(int keyNum) {
        this.keyNum = keyNum;
        isLocked = true;
    }
    public void lock(int keyNum) {
        if (keyNum == this.keyNum) {
            isLocked = true;
            frontMap.outDoor.isLocked = true;
            gp.ui.showMessage("Lock");
        }
        
    }
    public void unlock(int keyNum) {
        if (keyNum == this.keyNum) {
            isLocked = false;
            frontMap.outDoor.isLocked = false;
            gp.ui.showMessage("UnLock");
        }
    }

    public void interacted (Player player) {
        
    }

    public void run () {
        if (!isLocked && frontMap != null) gp.cWorld.changeMapFlag(frontMap.mapNum);
    }
}

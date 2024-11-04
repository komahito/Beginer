package object;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;
import tile.TileManager;
import tile.Map;

public class OBJ_House extends SuperObject implements EnterKey, NeedKey {
    GamePanel gp;
    public Map frontMap;
    public Map backMap;

    public int keyNum = 0;
    boolean isLocked = false;

    public OBJ_House (GamePanel gp) {
        // this.gp = gp;
        // collision = true;
        // disappear = false;

        // name = "House";
        // try {
        //     image = ImageIO.read(new File(main.Property.res + "/objects/house.png"));
        // } catch (IOException e){
        //     e.printStackTrace();
        // }
    }

    
    public void setKey(int keyNum) {
        // this.keyNum = keyNum;
        // isLocked = true;
    }
    public void lock(int keyNum) {
        // if (keyNum == this.keyNum) {
        //     isLocked = true;
        //     frontMap.inDoor.isLocked = true;
        //     gp.ui.showMessage("Lock");
        // }
    }
    public void unlock(int keyNum) {
        // if (keyNum == this.keyNum) {
        //     isLocked = false;
        //     frontMap.inDoor.isLocked = false;
        //     gp.ui.showMessage("Unlock");
        // }
    }
    public boolean checkIsLocked() {
        return isLocked;
    }

    public void interacted (Player player) {
    }

    public void run () {
        // if (!isLocked && frontMap != null) {
        //     gp.cWorld.changeMapFlag(frontMap.mapNum);
        // }
    }
}
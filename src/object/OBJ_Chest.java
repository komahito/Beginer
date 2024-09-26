package object;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import entity.Player;
import main.GamePanel;

public class OBJ_Chest extends SuperObject implements Inventory, EnterKey {
    KeyHandler keyH;

    public final int inventorySize = 13 * 4;
    public ArrayList<SuperObject> inventory = new ArrayList<>();

    public OBJ_Chest (GamePanel gp) {
        this.gp = gp;
        name = "Chest";
        collision = true;
        disappear = false;
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/chest (OLD).png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void interacted (Player player) {
    }

    public boolean addObject (SuperObject obj) {
        if (inventory.size() < inventorySize) {
            inventory.add(obj);
            return true;
        } else return false;
    }
    public SuperObject takeObject (int index) {
        if (!inventory.isEmpty()) {
            SuperObject obj = inventory.get(index);
            inventory.remove(index);
            return obj;
        } else return null;
    }

    public void run () {
        gp.playerState = false;
        gp.chestState = true;
        gp.ui.cInventoryIni(this);
    }
}

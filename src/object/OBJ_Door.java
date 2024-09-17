package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

import entity.Player;

public class OBJ_Door extends SuperObject {

    public OBJ_Door (GamePanel gp) {
        this.gp = gp;
        name = "Door";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/door.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

        collision = true;
        disappear = false;
    }

    public void pickedUp (Player player) {
        for (int i = 0; i < player.inventory.size(); i++) {
            if (player.inventory.get(i).name == "Key") {
                player.inventory.remove(i);
                disappear = true;
                gp.ui.showMessage("Used a key. You opened the door!");
                return;
            }
            gp.ui.showMessage("You need a key.");
        }

    }
    
}

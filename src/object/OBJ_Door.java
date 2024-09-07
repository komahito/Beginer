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
    }

    public void pickedUp (Player player) {

        if (player.hasKey > 0) {
            player.hasKey--;
            gp.ui.showMessage("You opened the door!");
        } else {
            gp.ui.showMessage("You need a key.");
        }

    }
    
}

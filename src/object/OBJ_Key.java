package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import entity.Player;
import main.GamePanel;

import java.io.File;

public class OBJ_Key extends SuperObject {
    public OBJ_Key (GamePanel gp) {
        this.gp = gp;
        name = "Key";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/key.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pickedUp (Player player) {
        disappear = true;
        boolean success = player.addObject(this);
        if (success) {
            gp.ui.showMessage("You got a key!");
        } else {
            disappear = false;
        }
    }
}
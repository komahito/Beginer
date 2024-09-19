package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import entity.Player;
import main.GamePanel;

import java.io.File;

public class OBJ_Key extends SuperObject implements Movable {
    public OBJ_Key (GamePanel gp) {
        this.gp = gp;
        name = "Key";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/key.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void interacted (Player player) {
        pickedUp(player);
    }

    public void pickedUp (Player player) {
        disappear = true;
        if (!player.addObject(this)) {
            disappear = false;
        } else {
            gp.ui.showMessage("You got a "+ name +"!");
        }
    }
}
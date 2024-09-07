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
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));
    }

    public void pickedUp (Player player) {
        player.hasKey++;
        gp.ui.showMessage("You got a key!");
    }
}
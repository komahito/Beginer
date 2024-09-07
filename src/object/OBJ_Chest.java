package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;
import main.GamePanel;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest (GamePanel gp) {
        this.gp = gp;
        name = "Chest";
        disappear = false;
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/chest (OLD).png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));
    }

    public void pickedUp (Player player) {
        gp.ui.gameFinished = true;
    }
}

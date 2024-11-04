package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Player;

import main.GamePanel;

public class OBJ_Boots extends SuperObject implements Movable {
    public OBJ_Boots (GamePanel gp) {
        this.gp = gp;
        name = "Boots";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/boots.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        // tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));
    }

    public void use () {

    }

    public void interacted (Player player) {
        pickedUp(player);
    }

    public void pickedUp (Player player) {
        // disappear = true;
        // if (!player.addObject(this)) {
        //     disappear = false;
        // } else {            
        //     player.speed += 2;
        //     gp.ui.showMessage("You got a " + name +"!");
        // }
    }
}

package drawer;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.Display;
import display.WalkDisplay;
import entity.Entity;
import entity.Player;
import main.GamePanel;

public class Drawer_Player extends DrawerfromEntity {
    private WalkDisplay walkDisplay;

    public Drawer_Player (GamePanel gp, Player player) {
        super(gp, (Entity) player);
        this.name = "boy";

        this.walkDisplay = new WalkDisplay(gp, this);

        screenX = this.gp.screenWidth / 2 - (this.gp.tileSize / 2);
        screenY = this.gp.screenHeight / 2 - (this.gp.tileSize / 2);
    }

    public Display takeTurn () {
        return walkDisplay;
        /*
         *  or return fightDisplay, emotionDisplay etc. depend on player state.
         */
    }
}

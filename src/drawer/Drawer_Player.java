package drawer;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.Display;
import display.WalkDisplay;
import display.WalkDisplay_Player;
import entity.Entity;
import entity.Player;
import main.GamePanel;

public class Drawer_Player extends DrawerfromEntity {
    private GamePanel gp;
    WalkDisplay_Player walkDisplay;

    public Drawer_Player (GamePanel gp, Player player) {
        this.entity = player;
        this.gp = gp;
        this.name = "boy";

        this.walkDisplay = new WalkDisplay_Player(gp, this);

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

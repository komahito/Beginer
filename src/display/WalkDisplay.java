package display;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import drawer.Drawer;
import drawer.DrawerfromEntity;
import main.GamePanel;
import main.Property;

public class WalkDisplay extends Display {
    public DrawerfromEntity drawerE;
    String direction;
    int spriteCounter = 0;
    int spriteNum = 1;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    private GetWalkImage getWalkImage;

    public WalkDisplay (GamePanel gp, DrawerfromEntity drawerE) {
        this.gp = gp;
        this.drawerE = drawerE;

        this.getWalkImage = new GetWalkImage(this);
    }

    public void draw(Graphics2D g2) {        
        direction = drawerE.entity.direction;
        BufferedImage image = null;

        spriteCounter ++;
        /* When walkDisplay.draw() is called, spriteCounter is incremented everytime.
         * So this class objects should be called only when walking.
         * 
         * There is no manipulation of checking collision in Display class. 
         *
         */

        if (spriteCounter > 13) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        switch(direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, drawerE.screenX, drawerE.screenY, gp.tileSize, gp.tileSize, null);

    }
}

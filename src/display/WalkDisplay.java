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
    DrawerfromEntity drawerE;
    String direction;
    int spriteCounter = 0;
    int spriteNum = 1;
    BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public WalkDisplay (GamePanel gp, DrawerfromEntity drawerE) {
        this.gp = gp;
        this.drawerE = drawerE;
        getImage();

        //TEMP
        System.out.println(drawerE.name);
    }

    private void getImage() {
        try{
            File file = new File(Property.res + "/player/" + drawerE.name + "_up1.png");
            up1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_up2.png");
            up2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_down1.png");
            down1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_down2.png");
            down2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_left1.png");
            left1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_left2.png");
            left2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_right1.png");
            right1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerE.name + "_right2.png");
            right2 = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {        
        direction = drawerE.entity.direction;
        BufferedImage image = null;

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

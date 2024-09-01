package entity;

import main.GamePanel;
import main.KeyHandler;
import main.Property;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    int standCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 14;
        solidArea.y = 26;
        solidArea.width = 20;
        solidArea.height = 20;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            File file = new File(Property.res + "/player/boy_up1.png");
            up1 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_up2.png");
            up2 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_down1.png");
            down1 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_down2.png");
            down2 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_left1.png");
            left1 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_left2.png");
            left2 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_right1.png");
            right1 = ImageIO.read(file);
            file = new File(Property.res + "/player/boy_right2.png");
            right2 = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed||keyH.downPressed||keyH.leftPressed||keyH.rightPressed){
            if (keyH.upPressed == true) {
                direction = "up";
            }
            else if (keyH.downPressed == true) {
                direction = "down";
            }
            else if (keyH.rightPressed == true) {
                direction = "right";
            }
            else if (keyH.leftPressed == true) {
                direction = "left";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISIOM
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "right": worldX += speed; break;
                    case "left": worldX -= speed; break;
                }
                spriteCounter++;
            }

            if (spriteCounter > 13) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }
    }

    public void pickUpObject (int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch (objectName) {
            case "Key":
                hasKey++;
                gp.obj[i] = null;
                gp.ui.showMessage("You got a key!");

                break;

            case "Door":
                if (hasKey > 0) {
                    gp.obj[i] = null;
                    hasKey--;
                    gp.ui.showMessage("You opened the door!");
                } else {
                    gp.ui.showMessage("You need a key.");
                }
                break;
            
            case "Boots":
                speed += 2;
                gp.obj[i] = null;
                gp.ui.showMessage("Speed up!");
                break;
            
            case "Chest":
                gp.ui.gameFinished = true;
                break;
            }
        }
    }

    public void draw(Graphics2D g2) {
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
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}

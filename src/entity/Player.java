package entity;

import main.GamePanel;
import main.KeyHandler;
import main.Property;
import object.OBJ_Chest;
import object.OBJ_Key;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import object.Inventory;

public class Player extends Entity implements Inventory{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    int[][] startCo = {{34, 7}, {14, 10}};

    public final int inventorySize = 20;
    public ArrayList<SuperObject> inventory = new ArrayList<>();

    // Gridbased move
    boolean moving = false;
    int pixelCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 1;
        solidArea.y = 1;
        solidArea.width = gp.tileSize - 2;
        solidArea.height = gp.tileSize - 2;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * (gp.maxWorldCol / 2 - 3);
        worldY = gp.tileSize * (gp.maxWorldRow / 2);
        speed = 4;
        direction = "down";
    }

    public void ini (int mapNum) {
        worldX = startCo[mapNum][0] * gp.tileSize;
        worldY = startCo[mapNum][1] * gp.tileSize;
    }

    public void moveTo (int x, int y) {
        worldX = x;
        worldY = y;
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
        if (gp.playerState) {
            walk();
        }
    }
    
    private void walk () {
        if (!moving){
            if ((keyH.upPressed||keyH.downPressed||keyH.leftPressed||keyH.rightPressed)){
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
                gp.cChecker.checkTile(this); // いずれマップのインデックスを渡して安定させる。

                // CHECK OBJECT COLLISIOM
                int objIndex = gp.cChecker.checkObject(this, true);
                interactObject(objIndex);

                moving = true;
            }
        
        } else {
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

            pixelCounter += speed;
            if (pixelCounter >= gp.tileSize) {
                moving = false;
                pixelCounter = 0;
            }
        }
    }

    public boolean addObject (SuperObject obj) {
        if (inventory.size() < inventorySize){
            inventory.add(obj);
            return true;
        } else return false;
    }

    public SuperObject takeObject (int index) {
        if (!inventory.isEmpty()) {
            SuperObject obj = inventory.get(index);
            inventory.remove(index);
            return obj;
        } else return null;
    }

    public void interactObject (int i) {
        for (int j = 0; j < gp.objs.size(); j++) {
            if (j == i) {
                gp.objs.get(j).adjFlag = true;
            } else gp.objs.get(j).adjFlag = false;
        }
        if (i != 999) {
            gp.objs.get(i).interacted(this);
            if (gp.objs.get(i).disappear){
                gp.objs.remove(i);
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

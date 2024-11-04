package entity;

import java.awt.image.BufferedImage;

import main.GamePanel;

import java.awt.Rectangle;

public class Entity {
    GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    public boolean collisionOn = false;
}
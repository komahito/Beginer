package main;

import entity.Entity;

public class TileCollisionChecker {
    private GamePanel gp;
    private Actor actor;
    private Entity entity;
    public TileCollisionChecker (GamePanel gp, Actor actor) {
        this.gp = gp;
        this.actor = actor;
        this.entity = actor.entity;
    }

    public void checkCollision () {
        int[][] mapTileNum = gp.map.mapTileNum;

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;

                tileNum1 = mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = mapTileNum[entityTopRow][entityRightCol];

                break;
            
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;

                tileNum1 = mapTileNum[entityBottomRow][entityLeftCol];
                tileNum2 = mapTileNum[entityBottomRow][entityRightCol];

                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;

                tileNum1 = mapTileNum[entityTopRow][entityRightCol];
                tileNum2 = mapTileNum[entityBottomRow][entityRightCol];
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;

                tileNum1 = mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = mapTileNum[entityBottomRow][entityLeftCol];
                break;
            
            default:
                tileNum1 = 0;
                tileNum2 = 0;
                break;
            
        }
        
        if (gp.map.tile[tileNum1].collision || gp.map.tile[tileNum2].collision) {
            entity.collisionOn = true;
        }
    }
}

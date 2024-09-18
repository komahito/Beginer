package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    
    public CollisionChecker (GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile (Entity entity) {
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

                tileNum1 = gp.tileM.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTileNum[entityTopRow][entityRightCol];

                break;
            
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTileNum[entityBottomRow][entityRightCol];

                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityTopRow][entityRightCol];
                tileNum2 = gp.tileM.mapTileNum[entityBottomRow][entityRightCol];
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;

                tileNum1 = gp.tileM.mapTileNum[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.mapTileNum[entityBottomRow][entityLeftCol];
                break;
            
            default:
                tileNum1 = 0;
                tileNum2 = 0;
                break;
            
        }
        
        if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
            entity.collisionOn = true;
        }
    }

    public int checkObject (Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.size(); i++){
            // Get entity's solid Area position.
            entity.solidArea.x += entity.worldX;
            entity.solidArea.y += entity.worldY;

                // Get object's solid Area position.
                gp.obj.get(i).solidArea.x += gp.obj.get(i).worldX;
                gp.obj.get(i).solidArea.y += gp.obj.get(i).worldY;

                switch (entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                        if (gp.obj.get(i).collision){
                            entity.collisionOn = true;
                        }
                        if (player) {
                            index = i;
                        }
                    }
                    break;

                case "down":
                    entity.solidArea.y += entity.speed;
                    if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                        if (gp.obj.get(i).collision){
                            entity.collisionOn = true;
                        }
                        if (player) {
                            index = i;
                        }
                    }
                    break;

                case "left":
                    entity.solidArea.x -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                        if (gp.obj.get(i).collision){
                            entity.collisionOn = true;
                        }
                        if (player) {
                            index = i;
                        }
                    }
                    break;

                case "right":
                    entity.solidArea.x += entity.speed;
                    if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                        if (gp.obj.get(i).collision){
                            entity.collisionOn = true;
                        }
                        if (player) {
                            index = i;
                        }
                    }
                    break;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                gp.obj.get(i).solidArea.x = gp.obj.get(i).solidAreaDefaultX;
                gp.obj.get(i).solidArea.y = gp.obj.get(i).solidAreaDefaultY;
            
        }

        return index;
    }
}

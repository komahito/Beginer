package main;

import entity.Entity;

public class CollisionChecker {
    // GamePanel gp;
    
    // public CollisionChecker (GamePanel gp) {
    //     this.gp = gp;
    // }

    // public void checkTile (Entity entity) {
    //     int[][] mapTileNum = gp.currentMap.mapTileNum;

    //     int entityLeftWorldX = entity.worldX + entity.solidArea.x;
    //     int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
    //     int entityTopWorldY = entity.worldY + entity.solidArea.y;
    //     int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

    //     int entityLeftCol = entityLeftWorldX / gp.tileSize;
    //     int entityRightCol = entityRightWorldX / gp.tileSize;
    //     int entityTopRow = entityTopWorldY / gp.tileSize;
    //     int entityBottomRow = entityBottomWorldY / gp.tileSize;

    //     int tileNum1, tileNum2;

    //     int mapNum = gp.currentMapNum;

    //     switch (entity.direction) {
    //         case "up":
    //             entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;

    //             tileNum1 = mapTileNum[entityTopRow][entityLeftCol];
    //             tileNum2 = mapTileNum[entityTopRow][entityRightCol];

    //             break;
            
    //         case "down":
    //             entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;

    //             tileNum1 = mapTileNum[entityBottomRow][entityLeftCol];
    //             tileNum2 = mapTileNum[entityBottomRow][entityRightCol];

    //             break;

    //         case "right":
    //             entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;

    //             tileNum1 = mapTileNum[entityTopRow][entityRightCol];
    //             tileNum2 = mapTileNum[entityBottomRow][entityRightCol];
    //             break;

    //         case "left":
    //             entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;

    //             tileNum1 = mapTileNum[entityTopRow][entityLeftCol];
    //             tileNum2 = mapTileNum[entityBottomRow][entityLeftCol];
    //             break;
            
    //         default:
    //             tileNum1 = 0;
    //             tileNum2 = 0;
    //             break;
            
    //     }
        
    //     if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
    //         entity.collisionOn = true;
    //     }
    // }

    // public int checkObject (Entity entity, boolean player) {
    //     int index = 999;

    //     for (int i = 0; i < gp.objs.size(); i++){
    //         // Get entity's solid Area position.
    //         entity.solidArea.x += entity.worldX;
    //         entity.solidArea.y += entity.worldY;

    //         // Get object's solid Area position.
    //         gp.objs.get(i).solidArea.x += gp.objs.get(i).worldX;
    //         gp.objs.get(i).solidArea.y += gp.objs.get(i).worldY;

    //         switch (entity.direction) {
    //         case "up":
    //             entity.solidArea.y -= entity.speed;
    //             if (entity.solidArea.intersects(gp.objs.get(i).solidArea)) {
    //                 if (gp.objs.get(i).collision){
    //                     entity.collisionOn = true;
    //                 }
    //                 if (player) {
    //                     index = i;
    //                 }
    //             }
    //             break;

    //         case "down":
    //             entity.solidArea.y += entity.speed;
    //             if (entity.solidArea.intersects(gp.objs.get(i).solidArea)) {
    //                 if (gp.objs.get(i).collision){
    //                     entity.collisionOn = true;
    //                 }
    //                 if (player) {
    //                     index = i;
    //                 }
    //             }
    //             break;

    //         case "left":
    //             entity.solidArea.x -= entity.speed;
    //             if (entity.solidArea.intersects(gp.objs.get(i).solidArea)) {
    //                 if (gp.objs.get(i).collision){
    //                     entity.collisionOn = true;
    //                 }
    //                 if (player) {
    //                     index = i;
    //                 }
    //             }
    //             break;

    //         case "right":
    //             entity.solidArea.x += entity.speed;
    //             if (entity.solidArea.intersects(gp.objs.get(i).solidArea)) {
    //                 if (gp.objs.get(i).collision){
    //                     entity.collisionOn = true;
    //                 }
    //                 if (player) {
    //                     index = i;
    //                 }
    //             }
    //             break;
    //         }

    //         entity.solidArea.x = entity.solidAreaDefaultX;
    //         entity.solidArea.y = entity.solidAreaDefaultY;

    //         gp.objs.get(i).solidArea.x = gp.objs.get(i).solidAreaDefaultX;
    //         gp.objs.get(i).solidArea.y = gp.objs.get(i).solidAreaDefaultY;
            
    //     }

    //     return index;
    // }
}

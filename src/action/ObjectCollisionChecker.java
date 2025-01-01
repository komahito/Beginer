package action;

import actor.Actor;
import entity.Entity;
import main.GamePanel;
import object.SuperObject;

public class ObjectCollisionChecker {
    private GamePanel gp;
    private Entity entity;

    public ObjectCollisionChecker (GamePanel gp, Actor actor) {
        this.gp = gp;
        this.entity = actor.entity;
    }

    public void checkCollision () {
        SuperObject[][] objectMap = gp.objectMap.objectMap;

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;
        
        SuperObject object1, object2;
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;

                object1 = objectMap[entityTopRow][entityLeftCol];
                object2 = objectMap[entityTopRow][entityRightCol];

                break;
            
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;

                object1 = objectMap[entityBottomRow][entityLeftCol];
                object2 = objectMap[entityBottomRow][entityRightCol];

                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;

                object1 = objectMap[entityTopRow][entityRightCol];
                object2 = objectMap[entityBottomRow][entityRightCol];
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;

                object1 = objectMap[entityTopRow][entityLeftCol];
                object2 = objectMap[entityBottomRow][entityLeftCol];
                break;
            
            default:
                object1 = null;
                object2 = null;
                break;
            
        }
        if ((object1 != null && object2 != null) && (object1.collision || object2.collision)) {
            entity.collisionOn = true;
        }

    }

}

package action;

import actor.Actor;
import entity.Entity;
import main.GamePanel;

public class ObjectCollisionChecker {
    private GamePanel gp;
    private Entity entity;

    public ObjectCollisionChecker (GamePanel gp, Actor actor) {
        this.gp = gp;
        this.entity = actor.entity;
    }

    public void checkCollision () {
        System.out.println("Check object collision.");
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

    }

}

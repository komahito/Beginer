package action;

import actor.Actor;
import main.GamePanel;

public class WalkAction extends Action {
    private boolean gridMoving;
    private TileCollisionChecker tileCC;
    private int pixelCounter = 0;

    public WalkAction (GamePanel gp, Actor actor) {
        super(gp, actor);
        this.tileCC = new TileCollisionChecker(gp, this.actor);
    }

    public void perform() {
        this.walk();
    }
    private void walk () {
        if (!gridMoving){
            if (this.actor.judgeMovability.judgeMovablity()) {
                this.actor.defineDirection.defineDirection();
                // if (keyH.upPressed == true) {
                //     direction = "up";
                // }
                // else if (keyH.downPressed == true) {
                //     direction = "down";
                // }
                // else if (keyH.rightPressed == true) {
                //     direction = "right";
                // }
                // else if (keyH.leftPressed == true) {
                //     direction = "left";
                // }

                // CHECK TILE COLLISION
                this.actor.entity.collisionOn = false;
                this.tileCC.checkCollision();
                //gp.cChecker.checkTile(this); // いずれマップのインデックスを渡して安定させる。

                // CHECK OBJECT COLLISIOM
                // int objIndex = gp.cChecker.checkObject(this, true);
                // interactObject(objIndex);

                gridMoving = true;
            }
        
        } else {
            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!this.actor.entity.collisionOn) {
                switch (this.actor.entity.direction) {
                    case "up": this.actor.entity.worldY -= this.actor.entity.speed; break;
                    case "down": this.actor.entity.worldY += this.actor.entity.speed; break;
                    case "right": this.actor.entity.worldX += this.actor.entity.speed; break;
                    case "left": this.actor.entity.worldX -= this.actor.entity.speed; break;
                }
                //spriteCounter++;
            }

            // if (spriteCounter > 13) {
            //     if (spriteNum == 1) {
            //         spriteNum = 2;
            //     } else if (spriteNum == 2) {
            //         spriteNum = 1;
            //     }
            //     spriteCounter = 0;
            // }

            pixelCounter += this.actor.entity.speed;
            if (pixelCounter >= gp.tileSize) {
                gridMoving = false;
                pixelCounter = 0;
            }
        }
    }
    // public void interactObject (int i) {
    //     for (int j = 0; j < gp.objs.size(); j++) {
    //         if (j == i) {
    //             gp.objs.get(j).adjFlag = true;
    //         } else gp.objs.get(j).adjFlag = false;
    //     }
    //     if (i != 999) {
    //         gp.objs.get(i).interacted(this);
    //         if (gp.objs.get(i).disappear){
    //             gp.objs.remove(i);
    //         }
    //     }
    // }
}

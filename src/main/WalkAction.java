package main;

public class WalkAction implements Action {
    public void perform() {
        //this.walk();
    }
    private void walk () {
        // if (!moving){
        //     if ((keyH.upPressed||keyH.downPressed||keyH.leftPressed||keyH.rightPressed)){
        //         if (keyH.upPressed == true) {
        //             direction = "up";
        //         }
        //         else if (keyH.downPressed == true) {
        //             direction = "down";
        //         }
        //         else if (keyH.rightPressed == true) {
        //             direction = "right";
        //         }
        //         else if (keyH.leftPressed == true) {
        //             direction = "left";
        //         }

        //         // CHECK TILE COLLISION
        //         collisionOn = false;
        //         gp.cChecker.checkTile(this); // いずれマップのインデックスを渡して安定させる。

        //         // CHECK OBJECT COLLISIOM
        //         int objIndex = gp.cChecker.checkObject(this, true);
        //         interactObject(objIndex);

        //         moving = true;
        //     }
        
        // } else {
        //     // IF COLLISION IS FALSE, PLAYER CAN MOVE
        //     if (!collisionOn) {
        //         switch (direction) {
        //             case "up": worldY -= speed; break;
        //             case "down": worldY += speed; break;
        //             case "right": worldX += speed; break;
        //             case "left": worldX -= speed; break;
        //         }
        //         spriteCounter++;
        //     }

        //     if (spriteCounter > 13) {
        //         if (spriteNum == 1) {
        //             spriteNum = 2;
        //         } else if (spriteNum == 2) {
        //             spriteNum = 1;
        //         }
        //         spriteCounter = 0;
        //     }

        //     pixelCounter += speed;
        //     if (pixelCounter >= gp.tileSize) {
        //         moving = false;
        //         pixelCounter = 0;
        //     }
        // }
    }
    public void interactObject (int i) {
        // for (int j = 0; j < gp.objs.size(); j++) {
        //     if (j == i) {
        //         gp.objs.get(j).adjFlag = true;
        //     } else gp.objs.get(j).adjFlag = false;
        // }
        // if (i != 999) {
        //     gp.objs.get(i).interacted(this);
        //     if (gp.objs.get(i).disappear){
        //         gp.objs.remove(i);
        //     }
        // }
    }
}

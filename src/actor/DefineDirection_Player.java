package actor;

import main.GamePanel;
import main.KeyHandler;

public class DefineDirection_Player extends DefineDirection {
    private KeyHandler keyH;
    private Actor_Player actorP;

    public DefineDirection_Player (GamePanel gp, KeyHandler keyH, Actor_Player actor) {
        super(gp, (Actor) actor);
        this.keyH = keyH;
        this.actorP = (Actor_Player) actor;
    }
    public void defineDirection () {
        if (keyH.upPressed == true) {
            actorP.player.direction = "up";
        }
        else if (keyH.downPressed == true) {
            actorP.player.direction = "down";
        }
        else if (keyH.rightPressed == true) {
            actorP.player.direction = "right";
        }
        else if (keyH.leftPressed == true) {
            actorP.player.direction = "left";
        }
    }
}

package action;

import actor.Actor;
import actor.Actor_Player;
import main.GamePanel;
import main.KeyHandler;

public abstract class ActionfromPlayer extends Action {
    protected KeyHandler keyH;
    protected Actor_Player actor_Player;

    public ActionfromPlayer (GamePanel gp, KeyHandler keyH, Actor_Player actor_Player) {
        super(gp, (Actor) actor_Player);
        this.gp = gp;
        this.keyH = keyH;
        this.actor_Player = actor_Player;
    }
}

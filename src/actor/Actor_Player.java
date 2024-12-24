package actor;

import action.Action;
import action.WalkAction;
import entity.Entity;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;

public class Actor_Player extends Actor {
    private KeyHandler keyH;
    private WalkAction walkAction;
    public Player player;

    public Actor_Player (GamePanel gp, KeyHandler keyH, Player player) {
        super(gp, (Entity) player);
        this.keyH = keyH;
        this.player = player;

        this.walkAction = new WalkAction(this.gp, this);
        this.defineDirection = new DefineDirection_Player(gp, this.keyH, this);
        this.judgeMovability = new JudgeMovability_Player(this.keyH, this);
    }
    public boolean energyIsEmp () {
        return false;
    }
    public Action takeTurn () {
        // in walk state,:
        return this.walkAction;
        // swim
        // run
        // reading
        // organizing luggage
        // operate machine etc.
    }
}

package main;

import entity.Entity;
import entity.Player;

public class Actor_Player extends Actor {
    private KeyHandler keyH;
    private WalkAction walkAction;
    public Player player;

    public Actor_Player (GamePanel gp, KeyHandler keyH, Player player) {
        super(gp, (Entity) player);
        this.keyH = keyH;
        this.player = player;

        this.walkAction = new WalkAction(this.gp, this);
        this.defineDirection = new DefineDirection_Player(gp, keyH, this);
        this.judgeMovability = new JudgeMovability_Player(keyH, this);
    }
    public boolean energyIsEmp () {
        return false;
    }
    public Action takeTurn () {
        return this.walkAction;
    }
}

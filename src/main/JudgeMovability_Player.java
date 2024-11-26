package main;

public class JudgeMovability_Player extends JudgeMovability {
    Actor_Player actor_Player;

    public JudgeMovability_Player (KeyHandler keyH, Actor_Player actor_Player) {
        super(keyH, (Actor) actor_Player);
        this.actor_Player = actor_Player;
    }
    public boolean judgeMovablity () {
        if ((keyH.upPressed||keyH.downPressed||keyH.leftPressed||keyH.rightPressed)){
            return true;
        } else return false;
    }
}

package main;

public abstract class JudgeMovability {
    protected Actor actor;
    protected KeyHandler keyH;
    
    public JudgeMovability (KeyHandler keyH, Actor actor) {
        this.keyH = keyH;
        this.actor = actor;
    }
    public abstract boolean judgeMovablity ();
}

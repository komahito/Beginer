package main;

public abstract class Action {
    protected GamePanel gp;
    protected Actor actor;
    public Action (GamePanel gp, Actor actor) {
        this.gp = gp;
        this.actor = actor;
    }
    // get Actor object when cnstructed.
    public abstract void perform();
}

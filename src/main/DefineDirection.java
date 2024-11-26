package main;

public abstract class DefineDirection {
    protected GamePanel gp;
    protected Actor actor;

    public DefineDirection (GamePanel gp, Actor actor) {
        this.gp = gp;
        this.actor = actor;
    }

    public abstract void defineDirection ();
}

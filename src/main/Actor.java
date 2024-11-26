package main;

import entity.Entity;

public abstract class Actor {
    protected GamePanel gp;
    protected Entity entity;
    protected DefineDirection defineDirection;
    protected JudgeMovability judgeMovability;

    public abstract boolean energyIsEmp ();
    public abstract Action takeTurn ();

    public Actor (GamePanel gp, Entity entity) {
        this.gp = gp;
        this.entity = entity;
    }
}

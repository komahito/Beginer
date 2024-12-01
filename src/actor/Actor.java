package actor;

import action.Action;
import entity.Entity;
import main.GamePanel;

public abstract class Actor {
    protected GamePanel gp;
    public Entity entity;
    public DefineDirection defineDirection;
    public JudgeMovability judgeMovability;

    public abstract boolean energyIsEmp ();
    public abstract Action takeTurn ();

    public Actor (GamePanel gp, Entity entity) {
        this.gp = gp;
        this.entity = entity;
    }
}

package drawer;

import display.Display;
import entity.Entity;
import main.GamePanel;

public abstract class DrawerfromEntity extends Drawer {
    public Entity entity;

    public DrawerfromEntity (GamePanel gp, Entity entity) {
        super(gp);
        this.entity = entity;
    }
}

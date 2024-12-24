package drawer;

import display.Display;
import main.GamePanel;
import object.SuperObject;

public abstract class DrawerfromObject extends Drawer {
    public SuperObject superObject;

    public DrawerfromObject (GamePanel gp, SuperObject object) {
        super(gp);
        this.superObject = object;
    }
}

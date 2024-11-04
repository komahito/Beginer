package drawer;

import display.Display;
import entity.Entity;
import entity.Player;
import main.GamePanel;

public abstract class Drawer {
    public GamePanel gp;
    public int screenX;
    public int screenY;
    public String name;
    
    public abstract Display takeTurn ();

}

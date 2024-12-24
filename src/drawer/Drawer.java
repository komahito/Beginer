package drawer;

import java.awt.image.BufferedImage;

import display.Display;
import entity.Entity;
import entity.Player;
import main.GamePanel;

public abstract class Drawer {
    protected GamePanel gp;
    public int screenX;
    public int screenY;
    public String name;
    public BufferedImage mainImage; // dir/name.png
    
    public Drawer (GamePanel gp) {
        this.gp = gp;
    }
    public abstract Display takeTurn ();

}

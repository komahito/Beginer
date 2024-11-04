package display;

import java.awt.Graphics2D;

import drawer.Drawer;
import main.GamePanel;

public abstract class Display {
    GamePanel gp;
    Drawer drawer;

    // get Drawer object when constructed.
    public abstract void draw (Graphics2D g2);
}

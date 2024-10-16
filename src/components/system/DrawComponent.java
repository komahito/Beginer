package components.system;

import components.SuperComponent;
import system.system.DrawSystem;
import java.awt.image.BufferedImage;

public class DrawComponent implements SuperComponent {
    private DrawSystem drawSystem;

    public BufferedImage image = null;
    public int screenX = 0;
    public int screenY = 0;
    public int width = 0;
    public int height = 0;

    public DrawComponent (DrawSystem drawSystem) {
        this.drawSystem = drawSystem;
    }
    
    public void retisterToSystem () {
        drawSystem.registration(this);
    }
}

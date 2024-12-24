package drawer;

import java.awt.image.BufferedImage;

import display.Display;
import display.DroppedObjectDisplay;
import main.GamePanel;
import object.OBJ_Key;
import object.SuperObject;

public class Drawer_Key extends DrawerfromObject {
    public OBJ_Key key;
    private DroppedObjectDisplay droppedObjectDisplay;
    private GetMainImage getMainImage = new GetMainImage(this);

    public Drawer_Key (GamePanel gp, OBJ_Key key) {
        super(gp, (SuperObject) key);
        this.name = "/objects/key";
        this.key = key;
        this.getMainImage.getMainImage();
        this.droppedObjectDisplay = new DroppedObjectDisplay(gp, this);
    }

    @Override
    public Display takeTurn() {
        return this.droppedObjectDisplay;
    }
    
}

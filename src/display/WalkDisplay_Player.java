package display;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import drawer.Drawer_Player;
import drawer.DrawerfromEntity;
import main.GamePanel;
import main.Property;

public class WalkDisplay_Player extends WalkDisplay {
    Drawer_Player drawerP;

    public WalkDisplay_Player (GamePanel gp, Drawer_Player drawerP) {
        super(gp, (DrawerfromEntity) drawerP);
        this.drawerP = drawerP;
        getImage();
    }

    protected void getImage() {
        try{
            File file = new File(Property.res + "/player/" + drawerP.name + "_up1.png");
            up1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_up2.png");
            up2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_down1.png");
            down1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_down2.png");
            down2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_left1.png");
            left1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_left2.png");
            left2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_right1.png");
            right1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + drawerP.name + "_right2.png");
            right2 = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

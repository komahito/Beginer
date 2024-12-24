package display;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Property;

public class GetWalkImage {
    private WalkDisplay walkD;
    private String name;
    public GetWalkImage (WalkDisplay walkD) {
        this.walkD = walkD;
        this.name = walkD.drawerE.name;
    }

    public void getImage () {

        try{
            File file = new File(Property.res + "/player/" + name + "_up1.png");
            this.walkD.up1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_up2.png");
            this.walkD.up2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_down1.png");
            this.walkD.down1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_down2.png");
            this.walkD.down2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_left1.png");
            this.walkD.left1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_left2.png");
            this.walkD.left2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_right1.png");
            this.walkD.right1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_right2.png");
            this.walkD.right2 = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package display;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Property;

public class GetWalkImage {
    private WalkDisplay walkD;
    private String name;
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    
    public GetWalkImage (WalkDisplay walkD) {
        this.walkD = walkD;
        this.name = walkD.drawerE.name;
        
        this.getImage();

        walkD.up1 = this.up1;
        walkD.up2 = this.up2;
        walkD.down1 = this.down1;
        walkD.down2 = this.down2;
        walkD.left1 = this.left1;
        walkD.left2 = this.left2;
        walkD.right1 = this.right1;
        walkD.right2 = this.right2;
    }

    private void getImage () {
        try{
            File file = new File(Property.res + "/player/" + name + "_up1.png");
            up1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_up2.png");
            up2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_down1.png");
            down1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_down2.png");
            down2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_left1.png");
            left1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_left2.png");
            left2 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_right1.png");
            right1 = ImageIO.read(file);
            file = new File(Property.res + "/player/" + name + "_right2.png");
            right2 = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

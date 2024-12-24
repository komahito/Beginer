package drawer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetMainImage {
    private Drawer drawer;
    private BufferedImage mainImage;

    public GetMainImage (Drawer drawer) {
        this.drawer = drawer;
    }

    public void getMainImage () {
        try {
            System.out.println(main.Property.res + drawer.name + ".png");
            this.drawer.mainImage = ImageIO.read(new File(main.Property.res + drawer.name + ".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

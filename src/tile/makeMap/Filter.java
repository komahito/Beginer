package tile.makeMap;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.File;

public class Filter {
    public static void main (String[] args) {
        String inname = main.Property.res + "/test/KOMATSUKE_Map.png";
        String outname = main.Property.res + "/test/KOMATSUKE_MapF.png";
        BufferedImage image = null;

        int r = 255;
        int g = 255;
        int b = 255;

        int white = (r << 16) + (g << 8) + b;
        int black = 0; //ROAD

        try{
            image = ImageIO.read(new File(inname));
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = image.getWidth();
        int height = image.getHeight();

        // EROSION
        for (int y = 1; y < height - 1; y+= 3) {
            for (int x = 1; x < width - 1; x+= 3) {
                if (ifHasColor(image, x, y, white)){
                    drawAll(image, x, y, white);
                }
            }
        }
        
        // DILATION
        for (int y = 1; y < height - 1; y+= 3) {
            for (int x = 1; x < width - 1; x+= 3) {
                if (ifHasColor(image, x, y, black)){
                    drawAll(image, x, y, black);
                }
            }
        }
        
        try{
            ImageIO.write(image, "png", new File(outname));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("正常に終了しました");
    }

    public static boolean ifHasColor (BufferedImage image, int a, int b, int color) {
        for (int y = b - 1; y <= b + 1; y++) {
            for (int x = a - 1; x <= a + 1; x++) {
                int p = image.getRGB(x, y) & 0xffffff;
                if (p == color) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void drawAll (BufferedImage image, int a, int b, int color) {
        for (int y = b - 1; y <= b + 1; y++) {
            for (int x = a - 1; x <= a + 1; x++) {
                image.setRGB(x, y, color);
            }
        }
        image.setRGB(a,b,color);
    }
}

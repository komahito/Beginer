package tile.makeMap;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class Binarization {
    int tv = 244;
    int lr = 2;
    String inname;
    String outname;
    BufferedImage image = null;

    public void Binarization (String inname, String outname){
        simpleBinarization();
    }

    public void simpleBinarization() {
        // JPEG画像の読み込み
        try{
            image = ImageIO.read(new File(inname));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 画像のイメージ型を確認(WindowsスタイルのBGRカラーモデルに対応)
        if (image.getType() != BufferedImage.TYPE_3BYTE_BGR) {
            System.out.println("対応してないカラーモデルだそうです: " + inname);
            return;
        }

        // 2値化
        int x, y;
        int width, height;
        int color, r, b, g;
        int p;
        int newColor = 0;

        width = image.getWidth();
        height = image.getHeight();

        for (y = 0; y < height; y++) {
            for (x = 0; x < width; x++) {
                // (x, y) の色を取得
                color = image.getRGB(x, y);

                // 色をRGBに分解
                b = color & 0xff;
                g = (color >> 8) & 0xff;
                r = (color >> 16) & 0xff;

                // rgbの平均を取る
                p = (r + g + b) / 3;

                // 2値化
                if (p < tv) { //BLACK
                    r = 0;
                    g = 0;
                    b = 0;
                } else { // WHITE
                    r = 255;
                    g = 255;
                    b = 255;
                }

                // RGBの色を合成
                newColor = (r << 16) + (g << 8) + b;
                

                // 合成した色をimageにセット
                image.setRGB(x, y, newColor);
            }
        }

        // imageをoutnameに出力
        try{
            ImageIO.write(image, "png", new File(outname));
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        // 正常に終了
        System.out.println("正常に終了しました。");

    }

    public static void main (String[] args) {
        // しきい値(木にするところ)
        int tv = 240;
        // low resolution
        int lr = 2;
        // ファイル名
        String inname = main.Property.res + "/test/KOMATSUKE.png";
        String outnameP = main.Property.res + "/test/KOMATSUKE_Map.png";
        // 画像格納クラス
        BufferedImage image = null;

        // JPEG画像の読み込み
        try{
            image = ImageIO.read(new File(inname));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 画像のイメージ型を確認(WindowsスタイルのBGRカラーモデルに対応)
        if (image.getType() != BufferedImage.TYPE_3BYTE_BGR) {
            System.out.println("対応してないカラーモデルだそうです: " + inname);
            return;
        }

        // 2値化
        int x, y;
        int width, height;
        int color, r, b, g;
        int p;
        int newColor = 0;

        width = image.getWidth();
        height = image.getHeight();

        for (y = 0; y < height; y++) {
            for (x = 0; x < width; x++) {
            
                if (x % lr == 0) { // lrピクセルごとに色を更新
                    // (x, y) の色を取得
                    color = image.getRGB(x, y);

                    // 色をRGBに分解
                    b = color & 0xff;
                    g = (color >> 8) & 0xff;
                    r = (color >> 16) & 0xff;

                    // rgbの平均を取る
                    p = (r + g + b) / 3;

                    // 2値化
                    if (p < tv) { //BLACK
                        r = 0;
                        g = 0;
                        b = 0;
                    } else { // WHITE
                        r = 255;
                        g = 255;
                        b = 255;
                    }

                    // RGBの色を合成
                    newColor = (r << 16) + (g << 8) + b;
                }
                

                // 合成した色をimageにセット
                image.setRGB(x, y, newColor);
            }
        }

        // imageをoutnameに出力
        try{
            ImageIO.write(image, "png", new File(outnameP));
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        // 正常に終了
        System.out.println("正常に終了しました。");
    }
}
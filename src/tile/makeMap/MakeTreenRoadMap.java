
/*
 * Binarization class（2値化）、（ノイズ除去）をlrと同じピクセルのタイルで出力して、ここで1タイル1文字に変換する。
*/


package tile.makeMap;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MakeTreenRoadMap {
    public static void main (String[] args) {
        // しきい値(木にするところ)
        int tv = 240;
        // low resolution
        int lr = 2;
        // ファイル名
        String inname = main.Property.res + "/test/KOMATSUKE_Map.png";
        String outnameT = main.Property.res + "/test/KOMATSUKE_Map.txt";
        // 画像格納クラス
        BufferedImage image = null;
        // テキスト格納
        BufferedWriter bw = null;

        // JPEG画像の読み込み
        try{
            image = ImageIO.read(new File(inname));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 画像のイメージ型を確認(WindowsスタイルのBGRカラーモデルに対応)
        if (image.getType() != BufferedImage.TYPE_3BYTE_BGR) {
            System.out.println("対応してないカラーモデルだそうです: " + inname);
        }

        //BufferedWriterのセッティング
        try{
            bw = new BufferedWriter(new FileWriter(new File(outnameT)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2値化
        int x, y;
        int width, height;
        int color, r, b, g;
        int p;
        int newColor;

        width = image.getWidth();
        height = image.getHeight();
        for (y = 0; y < height; y+=lr) {
            try{
                for (x = 0; x < width; x+=lr) {
                    // (x, y) の色を取得
                    color = image.getRGB(x, y);

                    // 色をRGBに分解
                    b = color & 0xff;
                    g = (color >> 8) & 0xff;
                    r = (color >> 16) & 0xff;

                    // rgbの平均を取る
                    p = (r + g + b) / 3;

                    // 2値化
                    if (p < tv) { //BLACK(TREE)
                        bw.write("0 ");
                    } else { // WHITE(SOIL)
                        bw.write("4 ");
                    }
                    
                }
            
            bw.newLine();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        try{
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 正常に終了
        System.out.println("正常に終了しました。");
    }
}
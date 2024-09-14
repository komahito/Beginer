package tile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.BufferedReader;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    int maxWorldCol;
    int maxWorldRow;
    public int[][] mapTileNum;
    String mapName = main.Property.res + "/maps/world01.txt";

    public TileManager(GamePanel gp) {
        this.gp = gp;

        // PREPARE TILES
        tile = new Tile[10];
        getTileImage();

        // MAKE mapTileNum matrix
        loadMap();
        gp.maxWorldCol = this.maxWorldCol;
        gp.maxWorldRow = this.maxWorldRow;
    }

    public void loadMap(){
        try{
            FileReader fr = new FileReader(new File(mapName));
            BufferedReader br = new BufferedReader(fr);

            br.mark(500000000);

            maxWorldCol = br.readLine().split(" ").length;
            maxWorldRow = (int) br.lines().count();
            mapTileNum = new int[maxWorldRow][maxWorldCol];

            int row = 0;
            int col = 0;
            br.reset();
            while ( col < maxWorldCol && row < maxWorldRow) {
                String line = br.readLine();
            
                String[] numbers = line.split(" ");
                while (col < maxWorldCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }

                if (col == maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        } catch(FileNotFoundException e) {
            System.err.println(e);
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public void getTileImage() {
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File(main.Property.res + "/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File(main.Property.res + "/tiles/water01.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File(main.Property.res + "/tiles/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File(main.Property.res + "/tiles/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File(main.Property.res + "/tiles/sand.png"));

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void draw(Graphics2D g2) {
        int worldRow = 0;
        int worldCol = 0;
        
        while (worldCol < maxWorldCol && worldRow < maxWorldRow) {
            int tileNum = mapTileNum[worldRow][worldCol];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            
            }
            
            worldCol++;

            if (worldCol == maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

        // for (col = 0; col < gp.maxScreenCol; col++) {
        //     for (row = 0; row < gp.maxScreenRow; row++) {
        //         int tileNum = mapTileNum[col][row];
        //         g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
        //         x += gp.tileSize;
        //     }
        //     x = 0;
        //     y += gp.tileSize;
        // }
    }
}

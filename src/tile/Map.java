package tile;
import drawer.Drawer;
import drawer.Drawer_Map;
import main.GamePanel;
import object.OBJ_MapDoor;

public class Map {
    GamePanel gp;
    public OBJ_MapDoor inDoor;
    public OBJ_MapDoor outDoor;

    public Drawer drawer = new Drawer_Map(gp, this);
    
    public LoadMap loadMap;
    public LoadTile loadTile;
    
    public String mapName;

    public int maxWorldCol, maxWorldRow;
    public int[][] mapTileNum;

    public Tile[] tile;

    public Map(GamePanel gp, String mapName) { // ex name "world01"
        this.gp = gp;
        this.mapName = main.Property.res + "/maps/" + mapName + ".txt";

        loadMap = new LoadMap(this);
        loadTile = new LoadTile(this);
    }

    // private void loadMap(String mapName){
    //     try{
    //         FileReader fr = new FileReader(new File(mapName));
    //         BufferedReader br = new BufferedReader(fr);

    //         br.mark(500000000);

    //         maxWorldCol = br.readLine().split(" ").length;
    //         maxWorldRow = (int) br.lines().count();
    //         mapTileNum = new int[maxWorldRow][maxWorldCol];

    //         int row = 0;
    //         int col = 0;
    //         br.reset();
    //         while ( col < maxWorldCol && row < maxWorldRow) {
    //             String line = br.readLine();
            
    //             String[] numbers = line.split(" ");
    //             while (col < maxWorldCol) {
    //                 int num = Integer.parseInt(numbers[col]);
    //                 mapTileNum[row][col] = num;
    //                 col++;
    //             }

    //             if (col == maxWorldCol) {
    //                 col = 0;
    //                 row++;
    //             }
    //         }

    //         br.close();

    //     } catch(Exception e) {
    //         e.printStackTrace();
    //     }
    //}

    // public void draw (Graphics2D g2) {
    //     int worldRow = 0;
    //     int worldCol = 0;
        
    //     while (worldCol < maxWorldCol && worldRow < maxWorldRow) {
    //         int tileNum = mapTileNum[worldRow][worldCol];

    //         int worldX = worldCol * gp.tileSize;
    //         int worldY = worldRow * gp.tileSize;
    //         int screenX = worldX - gp.player.worldX + gp.player.screenX;
    //         int screenY = worldY - gp.player.worldY + gp.player.screenY;

    //         if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
    //             worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
    //             worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
    //             worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
    //                 g2.drawImage(gp.tileM.getTile(tileNum).image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            
    //         }
            
    //         worldCol++;

    //         if (worldCol == maxWorldCol) {
    //             worldCol = 0;
    //             worldRow++;
    //         }
    //     }
    // }
    
}
/*
 * package tile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
    public int[][][] mapTileNum;
    String mapName0 = main.Property.res + "/maps/world01.txt";
    String mapName1 = main.Property.res + "/maps/interior01.txt";

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.mapTileNum = new int[gp.maxMapNum][][];

        // PREPARE TILES
        tile = new Tile[50];
        getTileImage();

        // MAKE mapTileNum matrix
        loadMap(0, mapName0);
        loadMap(1, mapName1);
        gp.maxWorldCol = this.maxWorldCol;
        gp.maxWorldRow = this.maxWorldRow;
    }

    public void loadMap(int mapNum, String mapName){
        try{
            FileReader fr = new FileReader(new File(mapName));
            BufferedReader br = new BufferedReader(fr);

            br.mark(500000000);

            maxWorldCol = br.readLine().split(" ").length;
            maxWorldRow = (int) br.lines().count();
            mapTileNum[mapNum] = new int[maxWorldRow][maxWorldCol];

            int row = 0;
            int col = 0;
            br.reset();
            while ( col < maxWorldCol && row < maxWorldRow) {
                String line = br.readLine();
            
                String[] numbers = line.split(" ");
                while (col < maxWorldCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[mapNum][row][col] = num;
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

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(new File(main.Property.res + "/tiles/sand.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(new File(main.Property.res + "/tiles/wall.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(new File(main.Property.res + "/tiles/grass01.png"));

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(new File(main.Property.res + "/tiles/floor01.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(new File(main.Property.res + "/tiles/table01.png"));
            tile[44].collision = true;

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void draw(Graphics2D g2) {
        int worldRow = 0;
        int worldCol = 0;

        int mapNum = gp.currentMapNum;
        
        while (worldCol < maxWorldCol && worldRow < maxWorldRow) {
            int tileNum = mapTileNum[gp.currentMapNum][worldRow][worldCol];

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

 */
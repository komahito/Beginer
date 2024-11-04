package display;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import drawer.Drawer;
import drawer.Drawer_Map;
import main.GamePanel;
import main.Property;
import tile.Tile;

public class MapDisplay extends Display {
    private Drawer_Map drawerM;

    public MapDisplay (GamePanel gp, Drawer drawer) {
        this.gp = gp;
        this.drawer = drawer;
        this.drawerM = (Drawer_Map) drawer;
    }

    @Override
    public void draw (Graphics2D g2) {
        int worldRow = 0;
        int worldCol = 0;
        
        while (worldCol < drawerM.map.maxWorldCol && worldRow < drawerM.map.maxWorldRow) {
            int tileNum = drawerM.map.mapTileNum[worldRow][worldCol];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.drawer.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.drawer.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.drawer.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.drawer.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.drawer.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.drawer.screenY) {
                    g2.drawImage(drawerM.map.tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            
            }
            
            worldCol++;

            if (worldCol == drawerM.map.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
    
}

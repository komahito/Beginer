package main;

import java.awt.Graphics2D;

public class MapDisplay implements Display {

    @Override
    public void draw (Graphics2D g2) {
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
                    g2.drawImage(gp.tileM.getTile(tileNum).image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            
            }
            
            worldCol++;

            if (worldCol == maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
    
}

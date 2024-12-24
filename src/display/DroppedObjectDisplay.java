package display;

import java.awt.Graphics2D;

import drawer.Drawer;
import drawer.DrawerfromObject;
import main.GamePanel;

public class DroppedObjectDisplay extends Display {
    public DrawerfromObject drawerO;

    public DroppedObjectDisplay (GamePanel gp, DrawerfromObject drawerO) {
        super(gp, (Drawer) drawerO);
        this.drawerO = drawerO;
    }

    public void draw(Graphics2D g2) {
        try {
        int worldX = this.drawerO.superObject.worldX;
        int worldY = this.drawerO.superObject.worldY;

        int screenX = worldX - gp.player.worldX + gp.player.drawer.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.drawer.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.drawer.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.drawer.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.drawer.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.drawer.screenY) {
            g2.drawImage(drawerO.mainImage, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}

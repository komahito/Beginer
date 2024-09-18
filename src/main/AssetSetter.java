package main;

import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Book;
import object.OBJ_Boots;
import object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter (GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        OBJ_Chest chest = new OBJ_Chest(gp);
        chest.worldX = 23* gp.tileSize;
        chest.worldY = 7* gp.tileSize;
        gp.obj.add(chest);
        // gp.obj[0] = new OBJ_Chest(gp);
        // gp.obj[0].worldX = 23 * gp.tileSize;
        // gp.obj[0].worldY = 7 * gp.tileSize;

        OBJ_Book book = new OBJ_Book(gp);
        book.worldX = 23* gp.tileSize;
        book.worldY = 8 * gp.tileSize;
        gp.obj.add(book);
        // gp.obj[1] = new OBJ_Book(gp);
        // gp.obj[1].worldX = 23 * gp.tileSize;
        // gp.obj[1].worldY = 8 * gp.tileSize;

        OBJ_Key key = new OBJ_Key(gp);
        key.worldX = 23 * gp.tileSize;
        key.worldY = 9* gp.tileSize;
        gp.obj.add (key);
        // gp.obj[2] = new OBJ_Key(gp);
        // gp.obj[2].worldX = 23 * gp.tileSize;
        // gp.obj[2].worldY = 9 * gp.tileSize;

        // gp.obj[3] = new OBJ_Key(gp);
        // gp.obj[3].worldX = 23 * gp.tileSize;
        // gp.obj[3].worldY = 10 * gp.tileSize;

        // gp.obj[4] = new OBJ_Key(gp);
        // gp.obj[4].worldX = 23 * gp.tileSize;
        // gp.obj[4].worldY = 40 * gp.tileSize;

        // gp.obj[5] = new OBJ_Key(gp);
        // gp.obj[5].worldX = 38 * gp.tileSize;
        // gp.obj[5].worldY = 8 * gp.tileSize;

        // gp.obj[6] = new OBJ_Door(gp);
        // gp.obj[6].worldX = 10 * gp.tileSize;
        // gp.obj[6].worldY = 11 * gp.tileSize;
        
        // gp.obj[7] = new OBJ_Door(gp);
        // gp.obj[7].worldX = 8 * gp.tileSize;
        // gp.obj[7].worldY = 28 * gp.tileSize;

        // gp.obj[8] = new OBJ_Door(gp);
        // gp.obj[8].worldX = 12 * gp.tileSize;
        // gp.obj[8].worldY = 22 * gp.tileSize;

        // gp.obj[9] = new OBJ_Chest(gp);
        // gp.obj[9].worldX = 10 * gp.tileSize;
        // gp.obj[9].worldY = 7 * gp.tileSize;

        // gp.obj[10] = new OBJ_Boots(gp);
        // gp.obj[10].worldX = 37 * gp.tileSize;
        // gp.obj[10].worldY = 42 * gp.tileSize;
    }
}

package main;

import object.OBJ_Door;
import object.OBJ_House;
import object.OBJ_Key;
import object.SuperObject;

import java.util.ArrayList;

import object.OBJ_Book;
import object.OBJ_Boots;
import object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;
    private ArrayList<ArrayList<SuperObject>> objs;
    
    public AssetSetter (GamePanel gp) {
        this.gp = gp;
        this.objs = new ArrayList<>();
        for (int i = 0; i < gp.maxMapNum; i++) {
            objs.add(new ArrayList<SuperObject>());
        }
    }

    public SuperObject getObj(int index) {
        return this.objs.get(gp.currentMapNum).get(index);
    }

    public void addObj (SuperObject obj) {
        objs.get(gp.currentMapNum).add(obj);
    }

    public void removeObj (int index) {
        objs.get(gp.currentMapNum).remove(index);
    }

    public int getSize() {
        return objs.get(gp.currentMapNum).size();
    }

    public void setObject() {
        OBJ_Chest chest = new OBJ_Chest(gp);
        chest.worldX = 23* gp.tileSize;
        chest.worldY = 7* gp.tileSize;
        objs.get(gp.currentMapNum).add(chest);

        OBJ_Book book = new OBJ_Book(gp);
        book.worldX = 23* gp.tileSize;
        book.worldY = 8 * gp.tileSize;
        objs.get(gp.currentMapNum).add(book);

        OBJ_Key key = new OBJ_Key(gp);
        key.worldX = 23 * gp.tileSize;
        key.worldY = 9* gp.tileSize;
        objs.get(gp.currentMapNum).add(key);

        OBJ_House house = new OBJ_House(gp);
        house.worldX = 33 * gp.tileSize;
        house.worldY = 7 * gp.tileSize;
        objs.get(gp.currentMapNum).add(house);
    }
}

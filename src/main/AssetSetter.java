package main;

import object.OBJ_Door;
import object.OBJ_House;
import object.OBJ_MapDoor;
import object.OBJ_Key;
import object.SuperObject;
import tile.Map;

import java.util.ArrayList;

import object.OBJ_Book;
import object.OBJ_Boots;
import object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;

    // OBJECTS
    public ArrayList<SuperObject> objs = new ArrayList<>();

    // MAPS
    final int maxMapNum = 10;
    public Map[] maps = new Map[maxMapNum];

    
    public AssetSetter (GamePanel gp) {
        this.gp = gp;

        objs.clear();
        setObject();
    }

    public void setObject() {
        // OBJ_Chest chest = new OBJ_Chest(gp);
        // chest.worldX = 23* gp.tileSize;
        // chest.worldY = 7* gp.tileSize;
        // objs.add(chest);

        // OBJ_Book book = new OBJ_Book(gp);
        // book.worldX = 23* gp.tileSize;
        // book.worldY = 8 * gp.tileSize;
        // objs.add(book);

        // OBJ_Key key = new OBJ_Key(gp);
        // key.worldX = 23 * gp.tileSize;
        // key.worldY = 9* gp.tileSize;
        // objs.add(key);

        // OBJ_House house = new OBJ_House(gp);
        // house.worldX = 33 * gp.tileSize;
        // house.worldY = 7 * gp.tileSize;
        // objs.add(house);

        // OBJ_Chest chest1 = new OBJ_Chest(gp);
        // chest1.worldX = 11 * gp.tileSize;
        // chest1.worldY = 8 * gp.tileSize;
        // objs.add(chest1);

        // OBJ_MapDoor mapDoor = new OBJ_MapDoor(gp);
        // mapDoor.worldX = 15 * gp.tileSize;
        // mapDoor.worldY = 10 * gp.tileSize;
        // objs.add(mapDoor);
        // mapDoor.adjX = mapDoor.worldX - gp.tileSize;
        // mapDoor.adjY = mapDoor.worldY;

        // maps[0] = new Map (gp, "world01", null , mapDoor);
        // maps[0].mapNum = 0;
        // maps[1] = new Map (gp, "interior01", mapDoor, null);
        // maps[1].mapNum = 1;

        // mapDoor.frontMap = maps[0];
        // mapDoor.backMap = maps[1];

        // house.frontMap = maps[1];
        // house.backMap = maps[0];

        // chest.map = maps[0];
        // book.map = maps[0];
        // key.map = maps[0];
        // house.map = maps[0];
        // chest1.map = maps[1];
        // mapDoor.map = maps[1];

        // house.setKey(20040420);
        // mapDoor.setKey(20040420);
        // key.setKeyNum(20040420);


    }
}

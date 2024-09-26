package main;

import tile.TileManager;
import tile.Map;

public class ChangeWorld {
    private GamePanel gp;
    private boolean changeMapFlag = true;
    private int nextMapNum = 0;
    
    public ChangeWorld(GamePanel gp) {
        this.gp = gp;
    }
    
    public void changeMap() {
        if (changeMapFlag) {
            gp.currentMapNum = nextMapNum;
            gp.currentMap = gp.aSetter.maps[nextMapNum];
            
            gp.objs.clear();
            for (int i = 0; i < gp.aSetter.objs.size(); i++) {
                if (gp.aSetter.objs.get(i).map.mapNum == nextMapNum) {
                    gp.objs.add(gp.aSetter.objs.get(i));
                }
            }

            gp.maxWorldRow = gp.aSetter.maps[nextMapNum].mapTileNum.length;
            gp.maxWorldCol = gp.aSetter.maps[nextMapNum].mapTileNum[0].length;
    
            gp.player.ini(nextMapNum);

            changeMapFlag = false;
        }
        
    }
    public void changeMapFlag (int nextMapNum) {
        changeMapFlag = true;
        this.nextMapNum = nextMapNum;
    }
}

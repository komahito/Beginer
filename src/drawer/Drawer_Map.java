package drawer;

import display.Display;
import display.MapDisplay;
import main.GamePanel;
import tile.Map;

public class Drawer_Map extends Drawer {
    public Map map;
    private MapDisplay mapDisplay;

    public Drawer_Map (GamePanel gp, Map map) {
        this.gp = gp;
        this.map = map;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        mapDisplay = new MapDisplay(gp, this);
    }

    @Override
    public Display takeTurn() {
        return mapDisplay;
        /*
         * or... or...? ah... map1, map2 etc.!
         */
    }
    
}

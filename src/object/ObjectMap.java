package object;

import main.GamePanel;

public class ObjectMap {
    private GamePanel gp;
    public SuperObject [][] objectMap;

    public ObjectMap (GamePanel gp) {
        this.gp = gp;
        this.objectMap = new SuperObject [gp.map.maxWorldRow][gp.map.maxWorldCol];
    }

    public void add (SuperObject object, int col, int row) {
        this.objectMap[row][col] = object;
    }

    public SuperObject get (int col, int row) {
        return this.objectMap[row][col];
    }
}

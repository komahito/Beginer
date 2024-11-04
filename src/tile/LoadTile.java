package tile;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadTile {
    private Map map;
    private Tile [] tile = new Tile[50];

    public LoadTile (Map map) {
        this.map = map;
        this.getTileImage();
        this.map.tile = this.tile;
    }

    private void getTileImage() {
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

}

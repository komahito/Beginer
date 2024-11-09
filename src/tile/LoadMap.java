package tile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import main.Property;

public class LoadMap {
    private Map map;
    private int maxWorldCol;
    private int maxWorldRow;
    private int[][] mapTileNum;

    public LoadMap (Map map) {
        this.map = map;
        this.loadMap(map.mapFileName);
        map.mapTileNum = this.mapTileNum;
    }

    private void loadMap(String mapFileName){
        try{
            FileReader fr = new FileReader(new File(mapFileName));
            BufferedReader br = new BufferedReader(fr);

            br.mark(500000000);

            maxWorldCol = br.readLine().split(" ").length;
            maxWorldRow = (int) br.lines().count();

            map.maxWorldCol = this.maxWorldCol;
            map.maxWorldRow = this.maxWorldRow;
            mapTileNum = new int[maxWorldRow][maxWorldCol];
            //map.mapTileNum = this.mapTileNum;

            int row = 0;
            int col = 0;
            br.reset();
            while ( col < maxWorldCol && row < maxWorldRow) {
                String line = br.readLine();
            
                String[] numbers = line.split(" ");
                while (col < maxWorldCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                }

                if (col == maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package main;

public class Drawer_Map implements Drawer {

    @Override
    public Display takeTurn() {
        MapDisplay mapDisplay = new MapDisplay();
        return mapDisplay;
    }
    
}

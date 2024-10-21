package main;

public class Drawer_Player implements Drawer {
    public Display takeTurn () {
        WalkDisplay walkDisplay = new WalkDisplay();
        return walkDisplay;
    }
}

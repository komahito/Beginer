package main;

import java.util.ArrayList;

import system.SuperSystem;

public class World {
    private ArrayList<SuperSystem> systems = new ArrayList<>();

    public void registration (SuperSystem system) {
        this.systems.add(system);
    }

    public void updateAllSystems () {
        for (int i = 0; i < this.systems.size(); i++) {
            this.systems.get(i).updateAllComponent();
        }
    }
}

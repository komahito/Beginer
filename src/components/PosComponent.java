package components;

import system.PosSystem;

public class PosComponent implements SuperComponent {
    private PosSystem posSystem; 
    
    public int worldX;
    public int worldY;

    public PosComponent (PosSystem posSystem) {
        this.posSystem = posSystem;
    }
    @Override
    public void retisterToSystem() {
        posSystem.registration(this);
    }
}

package state;

import java.util.ArrayList;

import main.GamePanel;

public class StateManager {
    private GamePanel gp;
    public static State currentState;
    
    // TEMP
    public Dynamics dynamicsState;
    public Pause pauseState;

    public StateManager (GamePanel gp) {
        this.gp = gp;

        //TEMP
        this.dynamicsState = new Dynamics(gp);
        this.pauseState = new Pause(gp);
        
        this.currentState = dynamicsState;
    }

    public State takeTurn() {
        return currentState;
    }
}

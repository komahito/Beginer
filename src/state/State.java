package state;

import main.GamePanel;

public abstract class State {
    protected GamePanel gp;

    public State(GamePanel gp) {
        this.gp = gp;
    }
    public abstract void run ();
}

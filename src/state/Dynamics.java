package state;

import action.Action;
import actor.Actor;
import main.GamePanel;

public class Dynamics extends State {
    public Dynamics (GamePanel gp) {
        super(gp);
    }

    @Override
    public void run() {
        for (int i = 0; i < this.gp.actors.size(); i++) {
            Actor actor = this.gp.actors.get(i);
            if (!actor.energyIsEmp()) {
                Action action = actor.takeTurn();
                action.perform();
            }
            
        }
    }
    
}

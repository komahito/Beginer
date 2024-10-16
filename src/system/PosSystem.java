package system;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;

import components.PosComponent;
import components.SuperComponent;
import main.World;

public abstract class PosSystem implements SuperSystem {
    private World world;
    private ArrayList<PosComponent> posComponents = new ArrayList<>();

    public PosSystem (World world) {
        this.world = world;
    }

    @Override
    public void registration(SuperComponent superComponent) {
        PosComponent posComponent = (PosComponent) superComponent;
        this.posComponents.add(posComponent);
    }

    @Override
    public void registerToWorld() {
        world.registration(this);
    }

    @Override
    public void updateAllComponent() {
        for (int i = 0; i < this.posComponents.size(); i++) {
            PosComponent posComponent = this.posComponents.get(i);
            // update pos of each component.
        }
    }

    /*
     * UPDATE FUNC
     */
    
}

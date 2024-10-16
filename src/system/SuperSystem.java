package system;

import components.SuperComponent;

public interface SuperSystem {
    public void registration (SuperComponent superComponent);
    public void registerToWorld ();

    public void updateAllComponent();
}

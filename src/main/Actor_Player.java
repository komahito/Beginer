package main;

public class Actor_Player implements Actor {
    public boolean energyIsEmp () {
        return false;
    }
    public Action takeTurn () {
        Action walkAction = new WalkAction();
        return walkAction;
    }
}

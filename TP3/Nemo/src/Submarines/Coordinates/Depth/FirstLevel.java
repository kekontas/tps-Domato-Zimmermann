package Submarines.Coordinates.Depth;

import Submarines.Capsule.CanThrowCapsule;
import Submarines.Capsule.CapsuleState;

public class FirstLevel extends DepthState{
     public FirstLevel (){

    }
    public DepthState moveUp() {
        return this.previousState;
    }
    public DepthState moveDown() {
        return new Deep(this, this);
    }
    public int getValue() {
        return -1;
    }
    public boolean canThrowCapsule() {
        return new CanThrowCapsule().throwCapsule();
    }
}

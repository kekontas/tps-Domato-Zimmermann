package Submarines.Coordinates.Depth;

import Submarines.Capsule.CanThrowCapsule;
import Submarines.Capsule.CapsuleState;

public class Surface extends DepthState{
    public DepthState depth;
    public Surface (){

    }
    public DepthState moveUp() {
        return new Surface();
    }
    public DepthState moveDown() {
        depth = new FirstLevel();
        return this;
    }
    public int getValue() {
        return 0;
    }
    public boolean canThrowCapsule() {
        return new CanThrowCapsule().throwCapsule();
    }
}

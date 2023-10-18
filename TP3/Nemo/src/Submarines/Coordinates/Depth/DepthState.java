package Submarines.Coordinates.Depth;

import Submarines.Capsule.CapsuleState;

public abstract class DepthState {
    public int value;

    public DepthState previousState;
    public abstract DepthState moveUp();
    public abstract DepthState moveDown();
    public  int getValue(){
        return this.value;
    }
    public abstract CapsuleState throwCapsule();

}

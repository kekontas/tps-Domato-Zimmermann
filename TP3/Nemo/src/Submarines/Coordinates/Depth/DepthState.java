package Submarines.Coordinates.Depth;

import Submarines.Capsule.CapsuleState;

public abstract class DepthState {
    public Object currentState;
    public DepthState previousState;
    public abstract DepthState moveUp();
    public abstract DepthState moveDown();
    public abstract int getValue();
    public abstract boolean canThrowCapsule();

}

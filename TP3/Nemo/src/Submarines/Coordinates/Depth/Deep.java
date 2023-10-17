package Submarines.Coordinates.Depth;

import Submarines.Capsule.CanThrowCapsule;
import Submarines.Capsule.CantThrowCapsule;
import Submarines.Capsule.CapsuleState;

public class Deep extends DepthState {
    public int depth;

    Deep (DepthState previousState, Object currentState){
        this.previousState = previousState;
        this.currentState = currentState;
    }
    public DepthState moveUp() {
        return this.previousState;
    }
    public DepthState moveDown() {
        return new Deep(this, this);
    }
    public int getValue() {
        return -1 + previousState.getValue();
    }
    public boolean canThrowCapsule() {
        return false;
    }
}

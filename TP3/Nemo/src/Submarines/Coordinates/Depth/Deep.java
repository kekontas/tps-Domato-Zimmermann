package Submarines.Coordinates.Depth;

import Submarines.Capsule.CapsuleState;
import Submarines.Capsule.ExplodedCapsule;

public class Deep extends DepthState {
    public int depth;
    public CapsuleState capsule;
    Deep (int value, DepthState previousState){
        this.value = value;
        this.previousState = previousState;
    }
    @Override
    public DepthState moveUp() {
        return this.previousState;
    }
    @Override
    public DepthState moveDown() {
        return new Deep(this.value -1, this);
    }

    public CapsuleState throwCapsule() {
        capsule = new ExplodedCapsule();
        return new ExplodedCapsule();
    }
}

package Submarines.Coordinates.Depth;


import Submarines.Capsule.CapsuleState;
import Submarines.Capsule.ThrownCapsule;

public class Surface extends DepthState{
    public CapsuleState capsule;
    public Surface (){
        this.value = 0;
    }
    @Override
    public DepthState moveUp() {
        return this;
    }
    @Override
    public DepthState moveDown() {
        return new FirstLevel();
    }
    public CapsuleState throwCapsule() {
        capsule = new ThrownCapsule();
        return new ThrownCapsule();
    }
}

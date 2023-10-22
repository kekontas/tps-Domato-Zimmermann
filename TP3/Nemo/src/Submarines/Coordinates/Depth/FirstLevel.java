package Submarines.Coordinates.Depth;


import Submarines.Capsule.CapsuleState;
import Submarines.Capsule.ThrownCapsule;

public class FirstLevel extends DepthState{
    public DepthState previousState;
    public CapsuleState capsule;
     public FirstLevel (){
         this.value = -1;
    }
    @Override
    public DepthState moveUp() {
        return this.previousState;
    }
    @Override
    public DepthState moveDown() {
        return new Deep(this.value -1, this);
    }

    @Override
    public CapsuleState throwCapsule() {

         return new ThrownCapsule();
    }
}

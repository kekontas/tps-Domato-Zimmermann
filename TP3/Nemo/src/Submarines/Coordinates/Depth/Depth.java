package Submarines.Coordinates.Depth;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.Coordinates;

public class Depth extends Coordinates {
    public DepthState depth = new Surface();

    public void moveUp() {
        depth=depth.moveUp();
    }
    public void moveDown() {
        depth = depth.moveDown();
    }
    public int getValue() {
        return depth.getValue();
    }
    public CapsuleState throwCapsule() {
        return depth.throwCapsule();
    }
}

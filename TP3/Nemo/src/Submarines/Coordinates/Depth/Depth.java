package Submarines.Coordinates.Depth;

import Submarines.Coordinates.Coordinates;

public class Depth extends Coordinates {
    public DepthState depth = new Surface();

    public void moveUp() {
        depth.moveUp();
    }
    public void moveDown() {
        depth.moveDown();
    }
    public int getValue() {
        return depth.getValue();
    }
}

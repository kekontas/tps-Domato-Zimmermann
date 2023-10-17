package Submarines.Directions;


import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;

public abstract class Direction  {

    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract String getDirection();
    public abstract void moveForward(CoordX x, CoordY y);

}

package Submarines.Directions;


import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Nemo;

public abstract class Direction  {

    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract String getDirection();
    public abstract void moveForward(Nemo nemo);

}

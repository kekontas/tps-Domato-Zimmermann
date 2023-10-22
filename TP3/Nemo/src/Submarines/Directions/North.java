package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Coordinates;
import Submarines.Nemo;

public class North extends Direction{
    public North(){}

    @Override
    public Direction turnLeft(){
        return new West();
    }

    @Override
    public Direction turnRight(){
        return new East();
    }
    @Override
    public void moveForward(Nemo nemo){nemo.y.moveUp();}
    @Override
    public String getDirection(){
        return "north";
    }
}

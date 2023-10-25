package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Coordinates;
import Submarines.Nemo;

public class South extends Direction{
    public South(){}

    @Override
    public Direction turnLeft(){
        return new East();
    }

    @Override
    public Direction turnRight(){
        return new West();
    }
    @Override
    public void moveForward(Nemo nemo){nemo.y.moveDown();}
    @Override
    public String getDirection(){
        return "south";
    }
}

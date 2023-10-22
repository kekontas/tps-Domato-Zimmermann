package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Nemo;

public class East extends Direction{
    public East(){}

    @Override
    public Direction turnLeft(){
        return new North();
    }
    @Override
    public Direction turnRight(){
        return new South();
    }

    @Override
    public void moveForward(Nemo nemo){nemo.x.moveUp();}
    @Override
    public String getDirection(){
        return "east";
    }
}

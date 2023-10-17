package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;

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
    public void moveForward(CoordX x, CoordY y){x.moveUp();}
    @Override
    public String getDirection(){
        return "east";
    }
}

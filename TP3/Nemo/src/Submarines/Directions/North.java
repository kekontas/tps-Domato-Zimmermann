package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Coordinates;

public class North extends Direction{
    public North(){}
    public Coordinates y;
    @Override
    public Direction turnLeft(){
        return new West();
    }

    @Override
    public Direction turnRight(){
        return new East();
    }
    @Override
    public void moveForward(CoordX x, CoordY y){y.moveUp();}
    @Override
    public String getDirection(){
        return "north";
    }
}

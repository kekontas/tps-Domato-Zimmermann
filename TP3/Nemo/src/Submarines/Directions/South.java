package Submarines.Directions;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Coordinates;

public class South extends Direction{
    public South(){}
    public Coordinates y;
    @Override
    public Direction turnLeft(){
        return new East();
    }

    @Override
    public Direction turnRight(){
        return new West();
    }
    @Override
    public void moveForward(CoordX x, CoordY y){y.moveDown();}
    @Override
    public String getDirection(){
        return "South";
    }
}

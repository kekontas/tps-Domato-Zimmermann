package Submarines.Directions;


import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;

public class West extends Direction{
    public West(){}
    public CoordX x ;
    @Override
    public Direction turnLeft(){
        return new South();
    }

    @Override
    public Direction turnRight(){
        return new North();
    }
    @Override
    public void moveForward(CoordX x, CoordY y){
        x.moveDown();
    }
    @Override
    public String getDirection(){
        return "west";
    }
}

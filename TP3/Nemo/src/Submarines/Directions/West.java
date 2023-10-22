package Submarines.Directions;


import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Nemo;

public class West extends Direction{
    public West(){}

    @Override
    public Direction turnLeft(){
        return new South();
    }

    @Override
    public Direction turnRight(){
        return new North();
    }
    @Override
    public void moveForward(Nemo nemo){
        nemo.x.moveDown();
    }
    @Override
    public String getDirection(){
        return "west";
    }
}

package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public class CommandU extends Commands{
    char type = 'u';
    public CommandU(){

    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(Nemo nemo){

        nemo.depth.moveUp();
    }
}

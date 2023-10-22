package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public class CommandF extends Commands{
    char type = 'f';
    public CommandF (){}
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(Nemo nemo){
        nemo.directions.get(nemo.directions.size()-1).moveForward(nemo);
    }
}

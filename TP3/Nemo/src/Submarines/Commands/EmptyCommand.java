package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public class EmptyCommand extends Commands{
    String type = "";
    public void doYourThing(Nemo nemo){
        //do nothing
    }
    public boolean equalsType(char c){
        return type.equals(c);
    }
}

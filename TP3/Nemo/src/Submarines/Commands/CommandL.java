package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public class CommandL extends Commands{
    char type = 'l';
    public CommandL (){}
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(Nemo nemo){
        nemo.directions.add(nemo.directions.get(nemo.directions.size()-1).turnLeft());

    }
}

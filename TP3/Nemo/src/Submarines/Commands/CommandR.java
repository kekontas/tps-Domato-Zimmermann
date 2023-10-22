package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public class CommandR extends Commands{
    char type = 'r';
    public CommandR(){
    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(Nemo nemo){
        nemo.directions.add(nemo.directions.get(nemo.directions.size()-1).turnRight());
    }
}

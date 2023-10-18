package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandF extends Commands{
    char type = 'f';
    public CommandF (){}
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> directions, CoordX x, CoordY y , Depth depth){
        directions.get(directions.size()-1).moveForward(x, y);
    }
}

package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandD extends Commands{
    char type = 'd';
    public void CommandD(){
    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> direction, CoordX x, CoordY y , Depth depth){
        depth.moveDown();
    }
}

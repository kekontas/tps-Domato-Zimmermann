package Submarines.Commands;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Coordinates.Depth.DepthState;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandL extends Commands{
    char type = 'l';
    public CommandL (){}
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> directions, CoordX x, CoordY y , Depth depth){
        directions.add(directions.get(directions.size()-1).turnLeft());

    }
}

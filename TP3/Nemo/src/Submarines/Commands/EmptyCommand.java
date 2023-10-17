package Submarines.Commands;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Coordinates.Depth.DepthState;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class EmptyCommand extends Commands{
    String type = "";
    public void doYourThing(ArrayList<Direction> direction, CoordX x, CoordY y , Depth depth){
        //do nothing
    }
    public boolean equalsType(char c){
        return type.equals(c);
    }
}

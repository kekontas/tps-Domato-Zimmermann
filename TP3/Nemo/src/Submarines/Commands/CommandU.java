package Submarines.Commands;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Coordinates.Depth.DepthState;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandU extends Commands{
    char type = 'u';
    public CommandU(){

    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> direction, CoordX x, CoordY y , Depth depth){
        depth.moveUp();
    }
}

package Submarines.Commands;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Coordinates.Depth.DepthState;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandR extends Commands{
    char type = 'r';
    public CommandR(){
    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> directions, CoordX x, CoordY y , Depth depth){
        directions.get(directions.size()-1).turnRight();
    }
}

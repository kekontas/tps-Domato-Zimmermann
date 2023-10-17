package Submarines.Commands;

import Submarines.Capsule.CapsuleState;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Coordinates.Depth.DepthState;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public class CommandM extends Commands{
    char type = 'm';
    static public String CantThrowCapsule = "El submarino no puede lanzar la capsula, Nemo esta lleno de chocolate";
    public CommandM(){
    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(ArrayList<Direction> directions, CoordX x, CoordY y , Depth depth){
        //depth.canThrowCapsule();
    }

}

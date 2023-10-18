package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;

import java.util.ArrayList;

public abstract class Commands {


    public abstract void doYourThing(ArrayList<Direction> direction, CoordX x, CoordY y , Depth depth);
    public abstract boolean equalsType(char c);
}

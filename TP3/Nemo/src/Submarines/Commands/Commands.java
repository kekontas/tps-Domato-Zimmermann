package Submarines.Commands;

import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Nemo;

import java.util.ArrayList;

public abstract class Commands {


    public abstract void doYourThing(Nemo nemo);
    public abstract boolean equalsType(char c);
}

package Submarines;
import java.util.ArrayList;

import Submarines.Capsule.CapsuleState;
import Submarines.Capsule.NotThrownCapsule;
import Submarines.Commands.*;
import Submarines.Coordinates.CoordX;
import Submarines.Coordinates.CoordY;
import Submarines.Coordinates.Coordinates;
import Submarines.Coordinates.Depth.Depth;
import Submarines.Directions.Direction;
import Submarines.Directions.East;

public class Nemo {
    public Coordinates coordinates;
    public CoordX x;
    public CoordY y;
    public Depth depth;
    public Direction direction;
    public CapsuleState capsule;

   // static public String CantAscendMore = "El submarino no puede ascender mas";
    static public String CantThrowCapsule = "El submarino no puede lanzar la capsula, Nemo esta lleno de chocolate";

    public ArrayList<Direction> directions = new ArrayList<Direction>();
    public ArrayList<Commands> availableCommands = new ArrayList<Commands>();
    public Nemo (){
        directions.add(new East());
        direction = directions.get(directions.size()-1);
        x = new CoordX();
        y = new CoordY();
        depth = new Depth();
        availableCommands.add(new CommandD());
        availableCommands.add(new CommandU());
        availableCommands.add(new CommandF());
        availableCommands.add(new CommandL());
        availableCommands.add(new CommandR());
        availableCommands.add(new EmptyCommand());
        availableCommands.add(new CommandM());
        capsule = new NotThrownCapsule();
    }

    public void command(Character parameters) {
        this.command(parameters.toString());
    }
    public void command(String parameters) {
        parameters
                .chars()
                .forEach(parameter -> applyCommandToChar((char) parameter));
    }
    public void applyCommandToChar(char parameter){
        availableCommands
                .stream()
                .filter(command -> command.equalsType(parameter))
                .forEach(command -> command.doYourThing(this));

    }

    public int getDepth(){
        return depth.getValue();
    }
    public int getX(){
        return x.getValue();
    }
    public int getY(){
        return y.getValue();
    }
    public String getDirection(){
        return directions.get(directions.size()-1).getDirection();
    }
    public boolean isCapsuleThrown(){
        return capsule.isCapsuleThrown();
    }
}

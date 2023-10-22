package Submarines.Commands;
import Submarines.Nemo;

import java.util.ArrayList;

public class CommandM extends Commands{
    char type = 'm';
    public CommandM(){
    }
    public boolean equalsType(char c){
        return type == c;
    }
    public void doYourThing(Nemo nemo){
        nemo.capsule = nemo.depth.throwCapsule();
    }

}

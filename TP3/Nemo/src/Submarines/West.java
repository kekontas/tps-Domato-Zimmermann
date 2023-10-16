package Submarines;

public class West extends Direction {

    public void changeOrientation(char parameter){
        if(parameter=='l'){
            direction = SOUTH;
        }
        if(parameter=='r'){
            direction = NORTH;
        }
    }
    public Direction getDirection(){
        return direction;
    }
}


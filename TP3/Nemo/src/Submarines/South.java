package Submarines;

public class South extends Direction{

    public void changeOrientation(char parameter){
        if(parameter=='l'){
            direction = EAST;
        }
        if(parameter=='r'){
            direction = WEST;
        }
    }
    public Direction getDirection(){
        return direction;
    }
}


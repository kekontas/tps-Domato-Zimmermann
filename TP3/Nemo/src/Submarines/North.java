package Submarines;

public class North extends Direction{
    public void changeOrientation(char parameter){
        if(parameter=='l'){
            direction = WEST;
        }
        if(parameter=='r'){
            direction = EAST;
        }
    }
    public Direction getDirection(){
        return direction;
    }
}


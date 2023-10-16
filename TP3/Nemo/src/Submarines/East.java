package Submarines;

public class East extends Direction {

    public void changeOrientation(char parameter){
        if (parameter=='l'){
            direction = NORTH;
        }
        if (parameter=='r'){
            direction = SOUTH;
        }
    }
    public Direction getDirection(){
        return direction;
    }
    /*public void moveFoward(){
        SubmarineGPS.moveFowardX();
    }*/
}

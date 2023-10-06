package Submarines;

public class SubmarineGPS {
    public int x = 0;
    public int y = 0;
    public int depth = 0;


    public SubmarineGPS() {}
    public int getDepth(){
        return depth;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void moveUp(){
        depth++;
    }
    public void moveDown(){
        depth--;
    }
    public void moveForward(String direction){
        if (direction == "east") {
            x++;
        } else if (direction == "west") {
            x--;
        } else if (direction == "north") {
            y++;
        } else if (direction == "south") {
            y--;
        }
    }


}

package Submarines.Coordinates;

public class CoordY extends Coordinates{
    public int y;
    public CoordY (){
        y = 0;
    }
    public void moveUp() {
        y++;
    }
    public void moveDown() {
        y--;
    }
    public int getValue() {
        return y;
    }
}

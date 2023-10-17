package Submarines.Coordinates;

public class CoordX extends Coordinates{
    public int x;
    public CoordX (){
        x = 0;
    }
    public void moveUp() {
        x++;
    }
    public void moveDown() {
        x--;
    }
    public int getValue() {
        return x;
    }
}

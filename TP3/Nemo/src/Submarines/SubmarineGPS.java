package Submarines;

public class SubmarineGPS {
    public East EAST;
    public West WEST;
    public North NORTH;
    public South SOUTH;

    public int x = 0;
    public int y = 0;
    public int depth = 0;


    public SubmarineGPS() {
    }

    public int getDepth() {
        return depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        depth++;
    }

    public void moveDown() {
        depth--;
    }
    /*public void moveFowardX(){
        x++;
    }*/

    public void moveForward(Direction direction) {
        if (direction.getDirection() == EAST) {
            x++;
        } else if (direction.getDirection() == WEST) {
            x--;
        } else if (direction.getDirection() == NORTH) {
            y++;
        } else if (direction.getDirection() == SOUTH) {
            y--;
        }
    }
}
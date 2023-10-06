package Submarines;

public class Direction {
    public String EAST = "east";
    public String WEST = "west";
    public String NORTH = "north";
    public String SOUTH = "south";
    public String direction = EAST;
    public Direction (){}

    public void changeOrientation(char parameter){
        if (parameter == 'l') {
            if (direction == EAST) {
                direction = NORTH;
            } else if (direction == NORTH) {
                direction = WEST;
            } else if (direction == WEST) {
                direction = SOUTH;
            } else if (direction == SOUTH) {
                direction = EAST;
            }
        }
        if (parameter == 'r') {
            if (direction == EAST) {
                direction = SOUTH;
            } else if (direction == SOUTH) {
                direction = WEST;
            } else if (direction == WEST) {
                direction = NORTH;
            } else if (direction == NORTH) {
                direction = EAST;
            }
        }
    }

    public String getDirection(){
        return direction;
    }



}

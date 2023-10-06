package Submarines;


public class Nemo {
    public SubmarineGPS coordinates;
    public Direction direction;

    public Nemo (){
        coordinates = new SubmarineGPS();
        direction = new Direction();
    }

    public void  move(String parameters){
        for (int i = 0; i < parameters.length(); i++) {
            char c = parameters.charAt(i);
            if (c == 'u') {
                coordinates.moveUp();
            } else if (c == 'd') {
                coordinates.moveDown();
            } else if (c == 'f') {
                coordinates.moveForward(getDirection());
            } else if (c == 'l') {
                direction.changeOrientation('l');
            } else if (c == 'r') {
                direction.changeOrientation('r');
            } else {
                throw new IllegalArgumentException("Invalid parameter");
            }
        }
    }
    public int getDepth(){
        return coordinates.getDepth();
    }
    public int getX(){
        return coordinates.getX();
    }
    public int getY(){
        return coordinates.getY();
    }
    public String getDirection(){
        return direction.getDirection();
    }
}

package Submarines;


public class Nemo {
    public SubmarineGPS coordinates;
    public East EAST;
    public Direction direction = EAST;
    public boolean CapsulaIsThrown = false;
   // static public String CantAscendMore = "El submarino no puede ascender mas";
    static public String CantThrowCapsule = "El submarino no puede lanzar la capsula, Nemo esta lleno de chocolate";
    public Nemo (){
        /*coordinates = new SubmarineGPS();*/
    }

    public void  comand(String parameters){
        for (int i = 0; i < parameters.length(); i++) {
            char c = parameters.charAt(i);
            if (c == 'u') {
                coordinates.moveUp();
                //if (coordinates.getDepth() > 1) {
                  //  throw new RuntimeException(CantAscendMore);
                //}

            } else if (c == 'd') {
                coordinates.moveDown();
            } else if (c == 'f') {
                coordinates.moveForward(direction);
            } else if (c == 'l') {
                direction.changeOrientation('l');
            } else if (c == 'r') {
                direction.changeOrientation('r');
            } else if (c == 'm'){
                if (getDepth() == 1 || getDepth() == -1) {
                    CapsulaIsThrown = true;
                }
                else {
                    throw new RuntimeException(CantThrowCapsule);
                }
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
    public Direction getDirection(){
        return direction;
    }
}

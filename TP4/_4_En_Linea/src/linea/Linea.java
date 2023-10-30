package linea;

public class Linea {
    public Linea(int prompt, int prompt1, char c) {
        if (prompt < 0 || prompt1 < 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
        if (prompt > 100 || prompt1 > 100) {
            throw new IllegalArgumentException("Base and height must be less than 100");
        }
        if (c != 'C' && c != 'D') {
            throw new IllegalArgumentException("Color must be C or D");
        }
        if (prompt == 0 || prompt1 == 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
    }

    public boolean show() {

        return false;
    }

    public boolean finished() {
        return false;
    }

    public void playRedkAt(int prompt) {
        
    }

    public void playBlueAt(int prompt) {
    }
}

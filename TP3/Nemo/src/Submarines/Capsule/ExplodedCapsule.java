package Submarines.Capsule;

public class ExplodedCapsule extends CapsuleState{
    static public String CantThrowCapsule = "El submarino no puede lanzar la capsula, Nemo esta lleno de chocolate";
    public ExplodedCapsule(){
        throw new RuntimeException(CantThrowCapsule);
    }
    @Override
    public boolean isCapsuleThrown() {
        throw new RuntimeException(CantThrowCapsule);
    }
}

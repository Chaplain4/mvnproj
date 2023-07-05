package abs;


//100% абстрактный класс
public interface Playable {
    //public abstract by default
    void play();
    public abstract void stop();
    //by default the field is public static final (constant)
    double VAL1 = Math.PI;
    public static final double VAL2 = Math.E;
}

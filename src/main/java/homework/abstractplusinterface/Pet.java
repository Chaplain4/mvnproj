package homework.abstractplusinterface;

public interface Pet {
    String getName();
    void setName(String name);
    default void play() {
        System.out.println(this.getClass().getName() + " is playing");
    }
}

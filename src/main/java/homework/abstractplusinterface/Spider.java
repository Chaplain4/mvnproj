package homework.abstractplusinterface;

public class Spider extends Animal {
    @Override
    public void eat() {
        System.out.println(this.getClass().getName() + " is eating");
    }

    public Spider() {
        super(8);
    }
}

package homework.abstractplusinterface;

public class Fish extends Animal implements Pet {
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Fish() {
        super(0);
        this.name = "";
    }

    @Override
    public void eat() {
        System.out.println(this.getClass().getName() + " is eating");
    }

    @Override
    public void walk() {
        System.out.println(this.getClass().getName() + " can't walk, has no legs");
    }
}

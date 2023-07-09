package homework.abstractplusinterface;

public class Cat extends Animal implements Pet {
    String name;

    @Override
    public void eat() {
        System.out.println(this.getClass().getName() + " is eating");
    }

    @Override
    public void play(){
        System.out.println(this.getClass().getName() + " is playing as a cat");
    }

    public void playAsPet(){
        Pet.super.play();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public Cat() {
        this("");
    }
}

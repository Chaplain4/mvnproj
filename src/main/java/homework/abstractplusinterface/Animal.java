package homework.abstractplusinterface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {
    private int legs;

    public abstract void eat();

    public void walk() {
        System.out.println(this.getClass().getName() + " is walking on " + legs + " legs");
    }

    public Animal(int legs) {
        this.legs = legs;
    }
}

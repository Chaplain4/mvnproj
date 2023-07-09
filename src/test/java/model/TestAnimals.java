package model;

import homework.abstractplusinterface.Animal;
import homework.abstractplusinterface.Fish;
import homework.abstractplusinterface.Pet;
import homework.abstractplusinterface.Spider;
import homework.abstractplusinterface.Cat;

public class TestAnimals {
    public static void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Fish a = new Fish();
        Animal e = new Spider();
        Cat p = new Cat();
        //Calling methods
        d.eat();
        d.play();
        d.walk();
        c.eat();
        c.play();
        c.walk();
        a.eat();
        a.walk();
        e.eat();
        e.walk();
        p.play();
        //Casting
        Fish fish = a;
        Spider spider = (Spider) e;
        a.walk();
        a.eat();
        a.play();
        e.eat();
        e.walk();
        //Polymorphism
        Animal[] animals = new Animal[] {d,c};
        for (Animal animal : animals) {
            animal.walk();
        }
        Pet[] pets = new Pet[] {d,c};
        for (Pet pet : pets) {
            pet.play();
        }
        //Using super
        c.playAsPet();
        c.play();
    }
}

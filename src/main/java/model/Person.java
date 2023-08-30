package model;

import lombok.*;

import java.beans.ConstructorProperties;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Cloneable, Comparable<Person> {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private Cat cat;
    private Car car;

    public Person(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(int id, String name, String lastname, int age, Cat cat) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && name.equals(person.name) && lastname.equals(person.lastname) && cat.equals(person.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, age);
    }

    @Override
    public Person clone() {
        Person clone = null;
        try {
            clone = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public int compareTo(Person o) {
        return this.lastname.compareTo(o.getLastname());
    }
}

package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    public Person(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    private int id;
    private String name;
    private String lastname;
    private int age;
    private Cat cat;

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
}

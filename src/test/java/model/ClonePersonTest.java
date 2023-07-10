package model;

public class ClonePersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(1, "John", "Johnson", 45, new Cat("Murzik"));
        Person p2 = new Person(1, "John", "Johnson", 45, new Cat("Murzik"));
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
        Person p3 = new Person(2, "Bob", "Bobson", 44, new Cat("Barsik"));
        Person p4 = p3.clone();
        System.out.println(p3.equals(p4));
        System.out.println(p3.hashCode() == p4.hashCode());
    }
}
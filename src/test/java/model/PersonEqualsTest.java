package model;

public class PersonEqualsTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(100);
        person.setName("John");
        person.setLastname("Johnson");
        person.setAge(55);

        // I.
        Person p2 = new Person(100,"John","Johnson",55);
        System.out.println("person == p2 ? " + (person == p2));
        Person p100 = p2;
        System.out.println("person == p2 ? " + (p100 == p2));
        p100.setId(1);
        System.out.println(p2.getId());

        // II. equals по умолчанию проверяет ссылки как в I. Чтобы сравнивать содержимое - нужна перегрузка
        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Barsik");
        Person person3 = new Person(100,"John","Johnson",55,cat1);
        Person person4 = new Person(100,"John","Johnson",55,cat2);
        System.out.println("person3 equals person4 ? " + person3.equals(person4));

        //Чтобы объекты сравнивались корректно, надо перегрузить метод Equals().
        // Как правило, объекты сравнивают по полям.

        // hashCode - функция, которая вернет целое число
        System.out.println("Cat1 hashCode : " + cat1.hashCode());
        System.out.println("Cat2 hashCode : " + cat1.hashCode());
        System.out.println("person3 hashCode : " + person3.hashCode());
        System.out.println("person4 hashCode : " + person4.hashCode());
    }
}
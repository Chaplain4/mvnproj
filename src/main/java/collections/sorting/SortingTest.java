package collections.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Car;
import model.Person;

import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList
                (new Person(1, "Mike", "Jackson", 40),
                        new Person(2, "Bike", "Gackson", 60),
                        new Person(3, "Qike", "Aackson", 37),
                        new Person(4, "Pike", "Cackson", 19),
                        new Person(5, "Gike", "Qackson", 55),
                        new Person(6, "Xike", "Lackson", 28)));
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList
                (new Car(1,"BMW"), new Car(2,"Tesla"),new Car(3, "Volvo"),
                        new Car(4,"VW"), new Car(5, "Opel"), new Car(6, "SAAB")));
        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).setCar(cars.get(i));
        }
        // 1st: comparable
        System.out.println(persons);
        System.out.println();
        Collections.shuffle(persons);
        System.out.println(persons);
        System.out.println();
        Collections.sort(persons);
        System.out.println(persons);
        System.out.println();

        List<String> strs = Arrays.asList("args", "AAA", "AB", "Y", "CC");
        Collections.sort(strs);
        System.out.println(strs);
        System.out.println();

        Collections.sort(cars);
        System.out.println(cars);
        System.out.println();

        // 1st: comparator
        Collections.sort(persons, new PersonsByCarIdComparator(true));
        System.out.println(persons);
        System.out.println();
        Collections.sort(persons, new PersonsByCarModelComparator());
        System.out.println(persons);
        System.out.println();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        System.out.println(persons);
        System.out.println();

        //

        Pizza pizza1 = new Pizza('s', "Cheese" , 2000, true);
        Pizza pizza2 = new Pizza('m', "Veggie" , 900, false);
        Pizza pizza3 = new Pizza('s', "Pepperoni" , 1900, true);
        Pizza pizza4 = new Pizza('l', "Pepperoni" , 2900, true);

        List<Pizza> pizzas = Arrays.asList(pizza1, pizza2, pizza3, pizza4);
        System.out.println(pizzas);
        System.out.println();
        Collections.sort(pizzas);
        System.out.println(pizzas);
        System.out.println();
        Collections.sort(pizzas, new PizzaByNameComparator());
        System.out.println(pizzas);
        System.out.println();
    }
}

class PersonsByCarIdComparator implements Comparator<Person> {
    private boolean asc = true;

    public PersonsByCarIdComparator(boolean asc) {
        this.asc = asc;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCar().compareTo(o2.getCar());
    }
}

class PersonsByCarModelComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCar().getModel().compareTo(o2.getCar().getModel());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Pizza implements Comparable<Pizza>{
    private char size; // s , m , l
    private String name;
    private long kcal;
    private boolean isThin;


    @Override
    public int compareTo(Pizza o) {
        return Long.valueOf(this.kcal).compareTo(o.kcal);
    }
}


class PizzaByNameComparator implements Comparator<Pizza> {
    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
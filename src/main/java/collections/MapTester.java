package collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTester {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(123, "John");
        map1.put(125, "Mike");
        System.out.println(map1.size());

        map1.forEach((k,v) -> {
            System.out.println("KEY: " + k + ", VALUE: " + v);
            System.out.println("!");
        });

        Map<Passport, Human> map2 = new HashMap<>();
        map2.put(new Passport("MP124312", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP124542", new Date()), new Human("Ben", "DD", 39));
        Passport mp104542 = new Passport("MP104542", new Date());
        map2.put(mp104542, new Human("Bill", "OJ", 29));
        map2.put(new Passport("MP1243112", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP1247542", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP243112", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP2475402", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP12431102", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP120470542", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP2431012", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP0247542", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP12343112", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP12457542", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP2436112", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP24775402", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP124311902", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP110470542", new Date()), new Human("Ben", "DD", 39));
        map2.put(new Passport("MP24612", new Date()), new Human("Bob", "JJ", 33));
        map2.put(new Passport("MP17542", new Date()), new Human("Ben", "DD", 39));
        System.out.println(map2.get(mp104542).name);
        for (Map.Entry<Passport, Human> entry : map2.entrySet()){
            System.out.println(entry.getKey().id);
        }
        Map <Human, Map<Passport, Human>> map3 = new HashMap<>();
        map3.put(new Human("Alex", "AA", 18), map2);
        for (Map.Entry<Human, Map<Passport, Human>> entry : map3.entrySet()){
            Human empl = entry.getKey();
            Map<Passport, Human> scope = entry.getValue();
            for (Map.Entry<Passport, Human> entryInt : scope.entrySet()) {
                System.out.printf(entryInt.getValue().name + " please take your passport with id " + entryInt.getKey().id);
                System.out.println();
            }
        }
    }
}

class Passport {
    String id;
    Date exp;

    public Passport(String id, Date exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (id != null ? !id.equals(passport.id) : passport.id != null) return false;
        return exp != null ? exp.equals(passport.exp) : passport.exp == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        return result;
    }
}

class Human {
    String name;
    String lName;
    int age;

    public Human(String name, String lName, int age) {
        this.name = name;
        this.lName = lName;
        this.age = age;
    }
}
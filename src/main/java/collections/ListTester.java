package collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class ListTester {
    public static void main(String[] args) {
        List<Cat> listOfCats = new ArrayList<>(300);
        listOfCats.add(new Cat());
        Cat cat = new Cat();
        cat.setName("Tom");
        listOfCats.add(cat);
        listOfCats.addAll(Arrays.asList(new Cat(), new Cat(), new Cat()));
        System.out.println("listOfCats size = " + listOfCats.size());


        List rawList = new ArrayList();
        rawList.add(1);
        rawList.add(1);
        rawList.add(new Cat());
        rawList.add("TOM");
        rawList.add("TOM");
        rawList.add(new StringBuilder());
        rawList.add(new Object());

        System.out.println("rawList size = " + rawList.size());
        Object obj = rawList.get(2);

        List<Cat> cats = new ArrayList<>(Arrays.asList(new Cat(), new Cat(), new Cat()));
        // remove last element
        cats.remove(cats.size() - 1);
        System.out.println(cats.size());
        cats.addAll(listOfCats);
        //
        Student student1 = new Student(23, "Mike", 9.8);
        Student student2 = new Student(20, "Nike", 8.0);
        Student student3 = new Student(23, "Like", 1.7);
        Student student4 = new Student(23, "Dike", 5.8);
        ArrayList<Student> group1 = new ArrayList<Student>(Arrays.asList(student1, student2, student3, student4));
        group1.addAll(group1);
        group1.addAll(group1);
        System.out.println("First student in list : " + group1.get(0));
        System.out.println("Last student in list : " + group1.get(group1.size() - 1));
        System.out.println(group1.remove(2));
        System.out.println(group1.remove(student3));
        group1.removeAll(Arrays.asList(new Student(1, "Alex", 7.1)));
        //walk
        for (int i = 0; i < group1.size(); i++) {
            Student st = group1.get(i);
            if (st.getAvg() >= 8) {
                System.out.println(st.getName().toUpperCase());
            }
        }
        //
        List <Student> listToRemove = new ArrayList<>();
        for (Student s : group1) {
            if (s.getAvg() < 7) {
                listToRemove.add(s);
            }
        }
        group1.removeAll(listToRemove);
        System.out.println("Left : " + group1);
        listToRemove.forEach(elem -> {
            System.out.println(elem.getName() + " : " + elem.getAvg());
        });

        // Iterator
        Iterator<Student> iterator = group1.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.getName().startsWith("M")) {
                iterator.remove();
                System.out.println("Student deleted");
            }
        }
        System.out.println("Left : " + group1);
        for(Iterator<Student> iter = group1.iterator(); iter.hasNext();) {
            System.out.println(iter.next().toString().toUpperCase());
        }

        group1.listIterator(2);
        System.out.println("**************");
        group1.sort(new StudentComparator(true));
        group1.forEach(e -> {
            System.out.println(e);
        });

        ArrayList<Cat> cats1 = new ArrayList<Cat>(Arrays.asList(new Cat(1, "Murzik","Black",5),
                new Cat(2, "Barsik","White",7), new Cat(3, "Vasek","Gray",9)));
        Iterator<Cat> catIterator = cats1.iterator();
        while (catIterator.hasNext()){
            Cat c = catIterator.next();
            if (c.getColor() == "Black") {
                iterator.remove();
                System.out.println("Cat deleted");
            }
        }
    }
}


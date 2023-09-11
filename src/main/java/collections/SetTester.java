package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public class SetTester {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Mike");
        set.add("John");
        set.add("One");
        set.add("Two");
        set.add("Three");
        System.out.println(set.size());

        for (String str : set) {
            System.out.println(str.toUpperCase());
        }

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str.toUpperCase());
            if (str.startsWith("T")) {
                iter.remove();
            }
        }
        System.out.println(set.size());

    }
}

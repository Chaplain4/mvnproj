package collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<String> strs = new LinkedList<>();
        strs.add("A");
        strs.add("B");
        strs.add("C");
        System.out.println(strs.get(1));
        System.out.println(strs.size());
        strs.add(1,"X");
        System.out.println(strs.size());
    }
}

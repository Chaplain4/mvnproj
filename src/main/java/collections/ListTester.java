package collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        List<Cat> list = new ArrayList<>();

        list.add(new Cat(0,"Tom"));
        list.add(new Cat(1,"Murzik"));
        list.addAll(Arrays.asList(new Cat(), new Cat(), new Cat()));
        list.add(null);
        
        System.out.println(list.size());

        List rawList = new ArrayList();

        rawList.add(1);
        rawList.add(new Cat());
        rawList.add("Tom");
        rawList.add(new StringBuilder());
        rawList.add(new Object());

        System.out.println(rawList.size());
        rawList.get(2);
    }
}


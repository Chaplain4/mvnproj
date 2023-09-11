package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTester {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("a", "b", null, "d");
        strs = new ArrayList<>(strs);
        strs.add(null);
        strs.forEach(s -> {
            s = s.toUpperCase();
            System.out.println(s);
        });
    }
}

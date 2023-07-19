package generics;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

public class StorageTest {

    @Test
    public void testStorage1() {
        Storage<Person> personStorage = new Storage<>();
        personStorage.add(new Person(1, "Ivan", "Ivanovich", 15));
        personStorage.add(new Person(2, "Ivan", "Ivanovich", 15));
        personStorage.add(new Person(3, "Ivan", "Ivanovich", 15));
        Assert.assertTrue(personStorage.getSize() == 3);
    }

    @Test(expected = NumberFormatException.class)
    public void testStorage2() {
        Storage<Number> numbers = new Storage<>();
        numbers.add(3.44); // boxing : double -> 3.44 -> new Double(3.44) -> (Number)
        numbers.add(new Long(213));
        numbers.add(new Double("213,789"));
    }

    @Test
    public void testStorage3() {
        Storage<String> strings = new Storage<>();
        strings.add("123"); // boxing : double -> 3.44 -> new Double(3.44) -> (Number)
        strings.add("test");
        strings.add(new String(" "));
        String s = strings.get(strings.getSize() + 1);
        Assert.assertNull(s);
    }
}

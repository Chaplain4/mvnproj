package generics;

public class GenericObject <T> {
    private T value;

    public GenericObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class GenericTest {
    public static void main(String[] args) {
        GenericObject<String> gen1 = new GenericObject<String>("Abc");
        String val1 = gen1.getValue();
        GenericObject<Integer> gen2 = new GenericObject<Integer>(123);
        int val2 = gen2.getValue();
        gen2.setValue(54); // 54 -> new Integer(54)
        gen2.setValue(new Integer(90)); // 90 -> new Integer(90)
        int i_1 = gen2.getValue().intValue();
        Double d = 10.5;
        Double d1 = new Double(80);
        GenericObject<GenericTest> gen3 = new GenericObject<GenericTest>(new GenericTest());
        GenericObject<Boolean> gen4 = new GenericObject<>(true);
    }
}
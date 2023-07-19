package generics;

public interface Pair<K, V> {
    K getKey();

    V getValue();

    default void print() {
        System.out.println(getKey() + " : " + getValue());
    }
}

class Assoc<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public Assoc(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class PairTest {
    public static void main(String[] args) {
        Assoc<String, String> assoc1 = new Assoc<>("Ball", "Мяч");
        Assoc<String, String> assoc2 = new Assoc<>("Wall", "Стена");
        Assoc<String, String> assoc3 = new Assoc<>("Call", "Вызов");
        System.out.println(assoc2.getValue());
        assoc1.print();

        Storage<Assoc<String, String>> assocStorage = new Storage<>();
        assocStorage.add(assoc1);
        assocStorage.add(assoc2);
        assocStorage.add(assoc3);
        System.out.println(assocStorage.get(2).getValue());
        Storage<Assoc<Integer, String>> assocStorage1 = new Storage<>();
        assocStorage1.add(new Assoc<>(1, "one"));
        assocStorage1.add(new Assoc<>(2, "two"));
        assocStorage1.add(new Assoc<>(3, "three"));
        assocStorage1.add(new Assoc<>(4, "four"));
        assocStorage1.add(new Assoc<>(5, "five"));
        assocStorage1.add(new Assoc<>(6, "six"));
        assocStorage1.add(new Assoc<>(7, "seven"));
        assocStorage1.add(new Assoc<>(8, "eight"));
        assocStorage1.add(new Assoc<>(9, "nine"));
        assocStorage1.add(new Assoc<>(10, "ten"));
        Storage<Assoc<Integer, String>> assocStorage2 = new Storage<>();
        assocStorage2.add(new Assoc<>(1, "один"));
        assocStorage2.add(new Assoc<>(2, "два"));
        assocStorage2.add(new Assoc<>(3, "три"));
        assocStorage2.add(new Assoc<>(4, "четыре"));
        assocStorage2.add(new Assoc<>(5, "пять"));
        assocStorage2.add(new Assoc<>(6, "шесть"));
        assocStorage2.add(new Assoc<>(7, "семь"));
        assocStorage2.add(new Assoc<>(8, "восемь"));
        assocStorage2.add(new Assoc<>(9, "девять"));
        assocStorage2.add(new Assoc<>(10, "десять"));
        Assoc<String,  Storage<Assoc<Integer, String>>> global1 = new Assoc<>("EN", assocStorage1);
        Assoc<String,  Storage<Assoc<Integer, String>>> global2 = new Assoc<>("RUS", assocStorage2);
        Storage<Assoc<String,  Storage<Assoc<Integer, String>>>> globalStorage = new Storage<>();
        globalStorage.add(global1);
        globalStorage.add(global2);
    }
}
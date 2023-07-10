package abs;

public interface Printable {
    void print();

    default void printDefault(){
        System.out.println("Default object : " + this.toString());
    }
}

class PrintableUser implements Printable, Playable {
    private String name;
    @Override
    public void print() {
        System.out.println("My name is " + name);
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}

class PrintableTest {
    public static void main(String[] args) {
        PrintableUser printableUser = new PrintableUser();
        printableUser.print();
        printableUser.printDefault();
    }
}
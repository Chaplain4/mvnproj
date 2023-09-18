package serial;

import lombok.Data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerialTester {

    public static void main(String[] args) throws IOException {
        // Serialization in file
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("D:\\io_tests\\serial\\user.txt"));

        Location l1 = new Location();
        l1.setPostalCode(123);
        l1.setAddress("BLR, Minsk , K. Marksa 32");
        User u1 = new User();
        u1.setId(111);
        u1.setName("Bill");
        u1.setLastname("Johnson");
        u1.setLocation(l1);
        u1.setPassword("123546789");

        Location l2 = new Location();
        l2.setPostalCode(123);
        l2.setAddress("BLR, Minsk , K. Marksa 32");
        User u2 = new User();
        u2.setId(842);
        u2.setName("Bill");
        u2.setLastname("Johnson");
        u2.setLocation(l1);
        u2.setPassword("123546789");

        Location l3 = new Location();
        l3.setPostalCode(123);
        l3.setAddress("BLR, Minsk , K. Marksa 32");
        User u3 = new User();
        u3.setId(234);
        u3.setName("Bill");
        u3.setLastname("Johnson");
        u3.setLocation(l1);
        u3.setPassword("123546789");

        Location l4 = new Location();
        l4.setPostalCode(123);
        l4.setAddress("BLR, Minsk , K. Marksa 32");
        User u4 = new User();
        u4.setId(543);
        u4.setName("Bill");
        u4.setLastname("Johnson");
        u4.setLocation(l1);
        u4.setPassword("123546789");

        oos.writeObject(Arrays.asList(u1, u2, u3, u4));
        oos.close();

        System.out.println(u1);


        // Deserialization (converting from bytes into Java Object)
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("D:\\io_tests\\serial\\user.txt"));
        try {
            ((List) ois.readObject()).forEach(u -> System.out.println(u));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

@Data
class User implements Serializable {
    private static final long serialVersionUID = 5723403455722220206L;
    private int id;
    private String lastname;
    private String name;
    private transient String password;
    private Location location;
}

@Data
class Location implements Serializable {
    private static final long serialVersionUID = -2009253341742107377L;
    private String address;
    private int postalCode;
}

@Data
class Home implements Serializable {
    private static final long serialVersionUID = 1L;
    private String address;
    private int postalCode;
}
package util;

import errors.CarNotFoundException;
import model.Car;
import model.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonsTest {
    @Test
    public void driveTest() {
        Person p1 = new Person();
        p1.setName("Ryan");
        p1.setLastname("Gosling");
        Car car = new Car();
        car.setModel("Chevy Impala");
        p1.setCar(car);
        try {
            PersonsUtil.drive(p1);
        } catch (CarNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = CarNotFoundException.class)
    public void driveTest1() throws CarNotFoundException {
        Person p1 = new Person();
        p1.setName("Ryan");
        p1.setLastname("Gosling");
        PersonsUtil.drive(p1);
    }

    @Test
    public void driveTest2()
    {
        Person p1 = null;
        try {
            PersonsUtil.drive(p1);
        } catch (CarNotFoundException e) {
            Throwable th = e.getCause();
            Assert.assertEquals(NullPointerException.class, th.getClass());
        }
    }
}

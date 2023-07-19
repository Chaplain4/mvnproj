package util;

import errors.CarNotFoundException;
import model.Car;
import model.Person;

public class PersonsUtil {
    public static void drive(Person p) throws CarNotFoundException {
        Car car = null;
        try {
            car = p.getCar();
        } catch (NullPointerException e) {
            throw new CarNotFoundException("Person is null", e);
        }
        if (car == null) {
            throw new CarNotFoundException(); // leave method
        }
        if (car.getModel() == null) {
            throw new CarNotFoundException("No model found"); // leave method
        }
        System.out.println(p.getName() + " " + p.getLastname() + " is driving " + p.getCar().getModel());
    }
}

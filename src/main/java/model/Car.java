package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Comparable<Car> {
    private int id;
    private String model;

    @Override
    public int compareTo(Car o) {
        return new Integer(this.id).compareTo(o.getId());
    }
}

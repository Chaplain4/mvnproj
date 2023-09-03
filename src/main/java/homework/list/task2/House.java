package homework.list.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House implements Comparable<House> {
    private int id;
    private int area;
    private int numberOfFloors;
    private String type;
    private int territoryArea;
    private String wallMaterial;
    private String foundationType;
    private long cost;
    private Address address;
    private List<String> communications;
    //сортировка по умолчанию по UID
    @Override
    public int compareTo(House o) {
        return Integer.compare(this.id, o.id);
    }
}

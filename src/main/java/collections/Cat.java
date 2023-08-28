package collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class Cat {
    private int id;
    private String name;
    private String color;
    private int age;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

package homework.list.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String populatedPlace;
    private String country;
    private String populatedPlaceName;
    private String street;
    private int houseNumber;
    private int postalCode;
}

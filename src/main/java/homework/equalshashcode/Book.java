package homework.equalshashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
public class Book extends Publication {
    private int numPages;

    public Book(long id, int version, String title, Author[] authors, int numPages) {
        super(id, version, title, authors);
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "numPages=" + numPages +
                "} " + super.toString();
    }
}

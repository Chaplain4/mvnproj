package homework.equalshashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
public class MagazineArticle extends Publication {
    private String magazineName;

    public MagazineArticle(long id, int version, String title, Author[] authors, String magazineName) {
        super(id, version, title, authors);
        this.magazineName = magazineName;
    }

    @Override
    public String toString() {
        return "MagazineArticle{" +
                "magazineName='" + magazineName + '\'' +
                "} " + super.toString();
    }
}

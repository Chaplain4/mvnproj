package homework.equalshashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MagazineArticle extends Publication {
    private String magazineName;

    public MagazineArticle(long id, int version, String title, Author[] authors, String magazineName) {
        super(id, version, title, authors);
        this.magazineName = magazineName;
    }
}

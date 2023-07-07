package homework.equalshashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BlogPost extends Publication {
    private String url;

    public BlogPost(long id, int version, String title, Author[] authors, String url) {
        super(id, version, title, authors);
        this.url = url;
    }
}

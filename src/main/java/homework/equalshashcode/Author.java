package homework.equalshashcode;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Author {
    private long id;
    private int version;
    private String firstName;
    private String lastName;
    private String[] publicationNames;
    public void updatePublicationNames(Publication publication) {
        for (int i = 0; i < publicationNames.length; i++) {
            if (publicationNames[i] == null) {
                this.publicationNames[i] = publication.getTitle();
                break;
            }
        }
    }
}

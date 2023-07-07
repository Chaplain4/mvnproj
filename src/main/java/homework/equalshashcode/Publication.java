package homework.equalshashcode;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Publication {
private long id;
private int version;
private String title;
private Author[] authors;
}


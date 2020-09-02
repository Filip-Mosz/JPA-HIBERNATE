import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Setter
public class Author {
    @Id
    @GeneratedValue
    Long AuthorId;

    @ManyToMany(mappedBy = "Author")
    List<Book> books;
//        @ManyToMany(mappedBy = "ChapterAuthor")
//        List<Chapter> chapters;

    String name;
}
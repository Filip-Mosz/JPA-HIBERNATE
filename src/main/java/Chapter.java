import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
public class Chapter {
    @Id
    @GeneratedValue
    Long ChapterId;

    Long ChapterAuthor;

    @ManyToOne
    private Book book;
}
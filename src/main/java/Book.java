import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
public class Book {
    @Id
    @GeneratedValue
    Long BookId;
    String title;
    Long Author;

    @OneToMany(mappedBy = "ChapterId")
    private List<Chapter> chapters;
}

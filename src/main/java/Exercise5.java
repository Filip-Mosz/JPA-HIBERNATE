//mapped by wskazuje na nazwé pola wøaßciciela relacji

import lombok.Setter;

import javax.persistence.*;
import javax.persistence.EntityManager;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {


        Author kipling = new Author();
        kipling.setName("Rudyard Kipling");
        Book jungleBook = new Book();
        jungleBook.setAuthor(kipling.AuthorId);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        saveEmployee(entityManager);
//        getEmployee(entityManager);
//        updateEmployee(entityManager);
//        refreshEmployee(entityManager);
//        deleteEmployee(entityManager);
//        detachAndMergeEmployee(entityManager);


        entityManager.persist(jungleBook);
        entityManager.persist(kipling);


        entityManager.close();
        entityManagerFactory.close();
    }


    @Entity
    @Setter
    public static class Book {
        @Id
        @GeneratedValue
        Long BookId;

        Long Author;

        @OneToMany(mappedBy = "ChapterId")
        private List<Chapter> chapters;
    }

    @Entity
    @Setter
    public static class Chapter {
        @Id
        @GeneratedValue
        Long ChapterId;

        Long ChapterAuthor;

        @ManyToOne
        private Book book;
    }

    @Entity
    @Setter
    public static class Author {
        @Id
        @GeneratedValue
        Long AuthorId;

        @ManyToMany(mappedBy = "Author")
        List<Book> books;
        @ManyToMany(mappedBy = "ChapterAuthor")
        List<Chapter> chapters;

        String name;
    }
}

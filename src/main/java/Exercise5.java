//mapped by wskazuje na nazwé pola wøaßciciela relacji

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exercise5 {
    public static void main(String[] args) {


        Author kipling = new Author();
        Author tolkien = new Author();
        Book hobbit = new Book();
        Book gadsbys = new Book();
        Book jungleBook = new Book();
        Book silmarillion = new Book();
        kipling.setName("Rudyard Kipling");
        jungleBook.setAuthor(kipling.AuthorId);
        gadsbys.setAuthor(kipling.AuthorId);
        gadsbys.setTitle("The Story of the Gadsbys");

        silmarillion.setTitle("Silmarillion");
        silmarillion.setAuthor(tolkien.AuthorId);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin(); //rozpoczyna transakcję bazodanową

            entityManager.persist(jungleBook);
            entityManager.persist(kipling);//persist musi wystąpić przed update'em
            jungleBook.setAuthor(kipling.AuthorId);

        entityManager.getTransaction().commit(); //kończy transakcję bazodanową

        entityManager.getTransaction().begin();
            jungleBook.setTitle("Jungle Book");
            entityManager.persist(gadsbys);
            entityManager.persist(tolkien);
            entityManager.persist(hobbit);
            entityManager.persist(silmarillion);
            gadsbys.setTitle("The Story of the Gadsbys");
            tolkien.setName("John Ronald Reuel Tolkien");
            hobbit.setAuthor(tolkien.AuthorId);
            hobbit.setTitle("The Hobbit or There and Back Again");
            gadsbys.setAuthor(kipling.AuthorId);
            silmarillion.setAuthor(tolkien.AuthorId);
            hobbit.setAuthor(tolkien.AuthorId);

            Book result = entityManager.find(Book.class, 3L);
        System.out.println(result);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }

}

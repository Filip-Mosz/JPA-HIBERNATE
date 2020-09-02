//mapped by wskazuje na nazwé pola wøaßciciela relacji

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exercise5 {
    public static void main(String[] args) {


        Author kipling = new Author();
        kipling.setName("Rudyard Kipling");
        Book jungleBook = new Book();
        jungleBook.setAuthor(kipling.AuthorId);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin(); //rozpoczyna transakcję bazodanową

        entityManager.persist(jungleBook);
        jungleBook.setAuthor(2L);
        entityManager.persist(kipling);

        entityManager.getTransaction().commit(); //kończy transakcję bazodanową


        entityManager.close();
        entityManagerFactory.close();
    }

}

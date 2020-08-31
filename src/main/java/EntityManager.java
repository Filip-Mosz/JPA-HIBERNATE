import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {
    public static void main (String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.close();
        entityManagerFactory.close();
    }
}

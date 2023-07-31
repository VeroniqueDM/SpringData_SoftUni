import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class T2_ChangeCasing {
    public static void main(String[] args) {

        // TASK 2

        // argument same as persistence unit name in persistence.xml; use utils in next demos;
        final EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni")
                .createEntityManager();

        entityManager.getTransaction().begin();
        List<Town> allTowns = entityManager.createQuery("FROM Town ", Town.class).getResultList();

        for (Town town : allTowns) {
            if (town.getName().length()>5) {
                // detach removes the town from the persistence context
                entityManager.detach(town);
                continue;
            }
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

import entities.inheritance.Bike;
import entities.inheritance.Car;
import entities.inheritance.Truck;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class InheritanceMain {
    public static void main(String[] args) {
        final EntityManager entityManager = Persistence.createEntityManagerFactory("relations")
                .createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new Car());
        entityManager.persist(new Bike());
        entityManager.persist(new Truck(10));

        Car car = entityManager.find(Car.class, 1);
        Car car2 = entityManager.find(Car.class, 2);



        entityManager.getTransaction().commit();
    }
}

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.Set;

public class T6_AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();

        final String lastName = scanner.nextLine();

        final Set<Employee> employees = Set.copyOf(entityManager
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList());


        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
//        newAddress.setTown(townForNewAddress);

        entityManager.persist(newAddress);

        employees.forEach(employee -> employee.setAddress(newAddress));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();
    }
}
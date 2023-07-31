import entities.Employee;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.Scanner;

public class T3_ContainsEmployee {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        entityManager.getTransaction().begin();

        try {
            final Employee employee = entityManager
                    .createQuery("from Employee where concat_ws(' ',first_name,last_name) = :fullName ", Employee.class)
                    .setParameter("fullName",fullName)
                    .getSingleResult();

            entityManager.getTransaction().commit();
            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }


    }
}

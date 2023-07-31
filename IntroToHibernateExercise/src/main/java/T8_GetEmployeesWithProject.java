import entities.Employee;

import java.util.Scanner;

public class T8_GetEmployeesWithProject {
    public static void main(String[] args) {
        Utils.createEntityManager()
                .createQuery("FROM Employee WHERE id = :employeeId", Employee.class)
                .setParameter("employeeId", new Scanner(System.in).nextInt())
                .getSingleResult()
                .printFullNameWithProjectNames();
    }
}
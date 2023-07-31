import entities.Employee;


public class T5_EmployeesFromDepartment {

    private static final String PRINT_FORMAT = "%s %s from Research and Development - $%d";

    public static void main(String[] args) {


        Utils.createEntityManager().createQuery("FROM Employee where department.name =: dName order by salary,id",
                        Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .forEach(Employee::printFullNameDepNameAndSalary);
    }
}

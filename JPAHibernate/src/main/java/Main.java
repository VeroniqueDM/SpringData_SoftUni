import entities.Student;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-jpa");
        // persistence unit name same as provided in persistence.xml

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        Student student = new Student("TeoLast");
//        em.persist(student);

//        //we can change the data/values before committing them to the database
//        student.setName("TeoUpdated");
//        em.persist(student);

//        Student studentEntity = em.find(Student.class, 3);

//        em.remove(studentEntity);
//        System.out.println(studentEntity);


        Student student = new Student("TeoLast",15,"Some School");
        em.persist(student);
        List<Student> fromStudent = em.createQuery("FROM Student ", Student.class).getResultList();
        fromStudent.forEach(s-> System.out.println(s));
        em.getTransaction().commit();
    }
}

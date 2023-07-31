package dtos;

import java.util.List;

public class StudentDTO {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isGraduated;
    private double averageGrade;
    private List<CourseDto> courses;


    public StudentDTO(String firstName, String lastName, int age, boolean isGraduated, double averageGrade, List<CourseDto> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isGraduated = isGraduated;
        this.averageGrade = averageGrade;
        this.courses = courses;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isGraduated=" + isGraduated +
                ", averageGrade=" + averageGrade +
                ", coursesTaken=" + courses +
                '}';
    }
}

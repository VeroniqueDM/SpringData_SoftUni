package dtos;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.Date;

public class CourseDto {
    @Expose
    private String name;
    @Expose
    private int lengthInWeeks;
    @Expose
//    private LocalDate createdAt;
    private Date createdAt;

    public CourseDto(String name, int lengthInWeeks, Date createdAt) {
        this.name = name;
        this.lengthInWeeks = lengthInWeeks;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "name='" + name + '\'' +
                ", lengthInWeeks=" + lengthInWeeks +
                ", createdAt=" + createdAt +
                '}';
    }
}

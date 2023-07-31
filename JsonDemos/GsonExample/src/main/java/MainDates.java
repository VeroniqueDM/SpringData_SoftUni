import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class MainDates {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting()
//                .setDateFormat("YYYY-MM-dd")
                .excludeFieldsWithoutExposeAnnotation()
                .create();

//        CourseDto mathDto = new CourseDto("Math", 12, Date.from(Instant.now()));
//
//        System.out.println(gson.toJson(mathDto));

        String mathJson = """
                {
                  "name": "Math",
                  "lengthInWeeks": 12,
                  "createdAt": "2023-07-29"
                }
                """;
        CourseDto mathCourseDto = gson.fromJson(mathJson, CourseDto.class);
        System.out.println(mathCourseDto);
    }
}

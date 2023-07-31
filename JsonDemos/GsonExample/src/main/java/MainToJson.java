import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDto;
import dtos.StudentDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MainToJson {
    public static void main(String[] args) {
//        Gson gson = new Gson();

        Gson gson = new GsonBuilder().setPrettyPrinting()
//                .excludeFieldsWithoutExposeAnnotation()
                .create();
        CourseDto biologyDto = new CourseDto("Biology",12, Date.from(Instant.now()));
        CourseDto mathDto = new CourseDto("Math",10,  Date.from(Instant.now()));

        StudentDTO studentDTO = new StudentDTO("first", null, 22, false, 5.5, List.of(mathDto,biologyDto));

        String json = gson.toJson(studentDTO);
        String jsonCourse = gson.toJson(biologyDto);
        System.out.println(jsonCourse);

//        List<dtos.StudentDTO> studentDTOList  = List.of(studentDTO);
//        String jsonList = gson.toJson(studentDTOList);
//        System.out.println(jsonList);



    }
}

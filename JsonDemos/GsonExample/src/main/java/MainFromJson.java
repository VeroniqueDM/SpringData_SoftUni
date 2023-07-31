import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDto;
import dtos.StudentDTO;

public class MainFromJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting()
//                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String jsonCourse = """
                {
                  "name": "Biology",
                  "lengthInWeeks": 12
                }
                """;


        String jsonArray = """
                [
                   {
                     "firstName": "first",
                     "age": 22,
                     "isGraduated": false,
                     "averageGrade": 5.5,
                     "courses": [
                       {
                         "name": "Math",
                         "lengthInWeeks": 10
                       },
                       {
                         "name": "Biology",
                         "lengthInWeeks": 12
                       }
                     ]
                   }
                 ]
                 
                """;

        CourseDto courseDto = gson.fromJson(jsonCourse, CourseDto.class);
        StudentDTO[] studentDTOsArray = gson.fromJson(jsonArray, StudentDTO[].class);
        System.out.println(courseDto);
    }
}

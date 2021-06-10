package az.code.springdata;

import az.code.springdata.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataApplication  {
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        StudentService studentService = context.getBean(StudentService.class);
//        studentService.generate();
//        studentService.getStudents().stream().forEach(s -> System.out.println(s));
//    }
//
//    @Autowired
//    public void setContext(ApplicationContext context){
//        this.context = context;
//    }
}

package az.code.springdata.controllers;

import az.code.springdata.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/any")
    public Student anyAccess(HttpServletRequest request){

        return Student.builder().name("any").build();
    }

    @GetMapping("/admin")
    public Student adminAccess(){
        return Student.builder().name("admin").build();
    }
    @GetMapping("/user")
    public Student userAccess(){
        return Student.builder().name("user").build();
    }

    @GetMapping("/auth")
    public Student authAccess(){
        return Student.builder().name("auth").build();
    }

}

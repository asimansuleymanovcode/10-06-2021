package az.code.springdata.services;

import az.code.springdata.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student generate();
}

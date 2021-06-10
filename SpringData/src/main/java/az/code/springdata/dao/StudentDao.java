package az.code.springdata.dao;

import az.code.springdata.models.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    Student generate();
}

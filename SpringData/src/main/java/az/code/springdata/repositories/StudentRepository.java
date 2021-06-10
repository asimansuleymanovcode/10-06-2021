package az.code.springdata.repositories;

import az.code.springdata.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.name like :name and s.surname like :surname")
    List<Student> findStudentByNameAndSurname( String name, String surname);
}

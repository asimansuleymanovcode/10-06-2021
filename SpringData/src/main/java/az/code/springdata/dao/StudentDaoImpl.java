package az.code.springdata.dao;

import az.code.springdata.models.Student;
import az.code.springdata.repositories.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao{
//    @PersistenceContext
//    EntityManager entityManager;

    StudentRepository studentRepository;

    public StudentDaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
//        return Streamable.of(studentRepository.findAll()).toList();
        return studentRepository.findStudentByNameAndSurname("N%", "M%");
//         studentRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "id"))).toList();

//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Student> query = cb.createQuery(Student.class);
//        Root<Student> student = query.from(Student.class);
//
//        query.where(cb.equal(student.get("name"), "Nurlan1"));
//        return entityManager.createQuery(query).getResultList();


//        return entityManager.createNamedQuery("findById").setParameter("id", 1l).getResultList();
    }

     @Override
    public Student generate() {
        return studentRepository.save(Student.builder().name("Nurlan").surname("Mammadov").build());
    }
}

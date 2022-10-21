package nurakedevgroup.com.appstartspringbootlesson.service;

import nurakedevgroup.com.appstartspringbootlesson.entity.Student;

import java.util.List;

public interface StudentService {
    Student newStudent(Student student);

    List<Student> findAll();

    Student getById(Long id);

    String update(Long id, Student student);

    String delete(Long id);
}

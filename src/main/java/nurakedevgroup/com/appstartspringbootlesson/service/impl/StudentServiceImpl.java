package nurakedevgroup.com.appstartspringbootlesson.service.impl;

import nurakedevgroup.com.appstartspringbootlesson.entity.Student;
import nurakedevgroup.com.appstartspringbootlesson.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final List<Student> list = new ArrayList<>(Arrays.asList(
            new Student(1L, "Shodibek", "995750212", "Physic 1-A"),
            new Student(2L, "Asilbek", "913124525", "Architecture 3-V"),
            new Student(3L, "Qobil", "978561232", "Software Engineering 104-19"),
            new Student(4L, "Sarvar", "887512313", "Digital Economic 107-22")
    ));

    @Override
    public List<Student> findAll() {
        return list;
    }
    @Override
    public Student getById(Long id) {
        for (Student student : list) {
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student newStudent(Student student) {
        student.setId((long)list.size()+1);
        list.add(student);
        return student;
    }

    @Override
    public String update(Long id,Student student){
        for (Student item : list) {
            if (item.getId().equals(id)){
                if (student.getName() != null && !item.getName().equals(student.getName()))
                    item.setName(student.getName());
                if (student.getPhoneNumber() != null && !item.getPhoneNumber().equals(student.getPhoneNumber()))
                    item.setPhoneNumber(student.getPhoneNumber());
                if (student.getCourseName() != null && !item.getCourseName().equals(student.getCourseName()))
                    item.setCourseName(student.getCourseName());
                if (student.getName() != null && !item.getName().equals(student.getName()))
                    item.setName(student.getName());
                return "O`zgartirildi";
            }

        }
        return "Bunday Student mavjud emas!";
    }

    @Override
    public String delete(Long id) {
            return list.removeIf(student -> (id != null && student.getId().equals(id)))?
                    "Student o`chirildi":
                    "Bunday student topilmadi.";

    }
}

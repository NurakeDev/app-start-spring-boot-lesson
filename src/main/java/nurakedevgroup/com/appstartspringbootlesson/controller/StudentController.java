package nurakedevgroup.com.appstartspringbootlesson.controller;

import nurakedevgroup.com.appstartspringbootlesson.entity.Student;
import nurakedevgroup.com.appstartspringbootlesson.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {


    @Autowired
    private StudentService service;

    @GetMapping(name = "Students", path = "/list")
    public List<Student> findAll(){
        return service.findAll();
    }

    @PostMapping(name = "save", path = "/save")
    public Student save(@RequestBody Student student){ //Create
        return service.newStudent(student);
    }

    @GetMapping(name = "read", path = "/{id}/by_id") //read
    public Student getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping(name = "update", path = "/{id}/update") //update
    public String update(@PathVariable("id") Long id, @RequestBody Student student){
        return service.update(id, student);
    }

    @DeleteMapping(name = "remove", path = "{id}/remove") //delete
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }

}

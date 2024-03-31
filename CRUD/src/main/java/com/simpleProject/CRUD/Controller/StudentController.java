package com.simpleProject.CRUD.Controller;

import com.simpleProject.CRUD.Entity.Student;
import com.simpleProject.CRUD.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class StudentController {
    @Autowired
    public StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.add(student);
    }

    @GetMapping("/list")
    public List<Student> getAllData() {
        return service.getAll();
    }

    @PutMapping("/edit/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        return service.update(student);
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable("id") Long id){
        service.delete(id);
    }
}

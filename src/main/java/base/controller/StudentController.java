package base.controller;

import base.dao.Student;
import base.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository repository;

    @Autowired
    public StudentController(final StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody final Student student) {
        return repository.save(student);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") final int id) {
        return repository.findById(id);
    }

    @GetMapping("/list")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

}

package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRecource {

    @GetMapping("/students/all")
    public ResponseEntity getAll() {
        Student student = new Student(1L,"Shoakbar", "Umarov", "3-kurs");
        Student student2 = new Student(2L,"Aziz", "Azizov", "3-kurs");
        Student student3 = new Student(3L,"Akbar", "Akbarov", "3-kurs");
        Student student4 = new Student(4L,"Qalandar", "Qalandarov", "3-kurs");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Student student = new Student(id,"Shoakbar", "Umarov", "5");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getone( @RequestParam Long id,
                                  @RequestParam String name,
                                  @RequestParam String lastName,
                                  @RequestParam String course) {
        Student student = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.ok("Deleted " + id);
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student studentNew) {
        Student student = new Student(1L,"Shoakbar", "Umarov", "3-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }

}

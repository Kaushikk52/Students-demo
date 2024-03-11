package com.example.students.controllers;

import com.example.students.entities.Student;
import com.example.students.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    @Autowired
    private StudentServices serv;


    @GetMapping("/all")
    private List<Student> getAllstudents(){
       return serv.getAllstudents();
    }

    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable String id){
        return serv.getStudent(id);
    }

    @PostMapping("/add")
    private void getStudent(@RequestBody Student student){
        serv.addStudent(student);
    }

    @PutMapping("/update")
    private Student updateStudent(@RequestBody Student student){
        return serv.updateStudent(student);
    }

    @DeleteMapping("/remove/{id}")
    private void removeStudent(@PathVariable String id){
        serv.removeStudent(id);
    }

}

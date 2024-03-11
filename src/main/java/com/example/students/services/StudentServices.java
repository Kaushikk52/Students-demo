package com.example.students.services;

import com.example.students.entities.Student;
import com.example.students.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo repo;

    public List<Student> getAllstudents(){
        return repo.findAll();
    }

    public Student getStudent(String id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Students not found"));
    }

    public void addStudent(Student student){
        repo.save(student);
    }

    public Student updateStudent(Student student){
        Student updatedstudent = repo.findById(student.getId()).orElseThrow(()-> new RuntimeException("Students not found"));
        updatedstudent.setName(student.getName());
        updatedstudent.setRollno(student.getRollno());
        updatedstudent.setStd(student.getStd());
        return updatedstudent;
    }

    public void removeStudent(String id){
        Student student = repo.findById(id).orElseThrow(()-> new RuntimeException("Students not found"));
        repo.delete(student);
    }



}

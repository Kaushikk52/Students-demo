package com.example.students.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Student {

    @Id
    private String id;
    private String name;
    private int rollno ;
    private int std;



    @PrePersist
    public void prePresist(){
        if(this.id==null){
            this.id = UUID.randomUUID().toString();
        }
    }
}

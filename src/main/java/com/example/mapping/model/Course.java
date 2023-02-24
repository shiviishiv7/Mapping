package com.example.mapping.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {

    @Id

    private String ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();
}

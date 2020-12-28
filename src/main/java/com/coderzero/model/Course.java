package com.coderzero.model;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ElementCollection()
    List<Syllabus> syllabusList;
}

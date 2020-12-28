package com.coderzero.model;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name ;
    @OneToOne
    private Address address;
    @ManyToMany
    private List<Group> my_groups  = new ArrayList<Group>();
}

package com.coderzero.model;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "fresher")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name ;
    @OneToOne
    private Address address;
    @ManyToMany
    private List<Group> my_groups  = new ArrayList<Group>();
    public Fresher(){
        System.out.println("Group constructor");
    }
}

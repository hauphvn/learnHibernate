package com.coderzero.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Syllabus {
    private String content;
    private int trainingTime;
}

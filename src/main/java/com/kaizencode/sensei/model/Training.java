package com.kaizencode.sensei.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private TrainingPlan trainingPlan;
    private Date trainingTime;
    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Series> series;

}

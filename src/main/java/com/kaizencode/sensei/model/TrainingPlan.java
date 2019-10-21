package com.kaizencode.sensei.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Series> plannedSeries;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Category> trainingPlanCategories;

    public List<Category> getTrainingPlanCategories() {
        trainingPlanCategories = new ArrayList<>();
        return trainingPlanCategories;
    }
}

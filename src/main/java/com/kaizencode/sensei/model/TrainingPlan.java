package com.kaizencode.sensei.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "training_plan_categories",
            joinColumns = @JoinColumn(name = "training_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<TrainingPlanCategory> trainingPlanCategories;

    public List<TrainingPlanCategory> getTrainingPlanCategories() {
        trainingPlanCategories = new ArrayList<>();
        return trainingPlanCategories;
    }
}

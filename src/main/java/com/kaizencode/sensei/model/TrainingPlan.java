package com.kaizencode.sensei.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrainingPlanCategory> getTrainingPlanCategories() {
        return trainingPlanCategories;
    }

    public void setTrainingPlanCategories(List<TrainingPlanCategory> trainingPlanCategories) {
        this.trainingPlanCategories = trainingPlanCategories;
    }

    public List<Series> getPlannedSeries() {
        return plannedSeries;
    }

    public void setPlannedSeries(LinkedList<Series> plannedSeries) {
        this.plannedSeries = plannedSeries;
    }
}

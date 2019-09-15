package com.kaizencode.sensei.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingPlanCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "trainingPlanCategories")
    private List<TrainingPlan> trainingPlanList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrainingPlan> getTrainingPlanList() {
        return trainingPlanList;
    }

    public void setTrainingPlanList(List<TrainingPlan> trainingPlanList) {
        this.trainingPlanList = trainingPlanList;
    }
}

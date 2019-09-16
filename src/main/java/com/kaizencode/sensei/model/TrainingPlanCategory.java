package com.kaizencode.sensei.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TrainingPlanCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "trainingPlanCategories")
    private List<TrainingPlan> trainingPlanList;

}

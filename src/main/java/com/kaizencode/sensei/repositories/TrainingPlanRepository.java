package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.model.TrainingPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Long> {
    List<TrainingPlan> findAllByTrainingPlanCategories_Name(String name);
}

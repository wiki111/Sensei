package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.model.TrainingPlanCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Long> {
    List<TrainingPlan> findAllByTrainingPlanCategories_Name(String name);
}

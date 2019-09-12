package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.models.TrainingPlan;
import org.springframework.data.repository.CrudRepository;

public interface TrainingPlanRepository extends CrudRepository<TrainingPlan, Long> {
}

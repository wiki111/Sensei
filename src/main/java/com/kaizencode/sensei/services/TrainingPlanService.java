package com.kaizencode.sensei.services;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.model.TrainingPlan;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanService {

    List<TrainingPlan> getTrainingPlans();
    TrainingPlan getTrainingPlanById(Long id);
    TrainingPlanCommand savePlanCommand(TrainingPlanCommand command);
    TrainingPlanCommand getTrainingCommandById(Long id);
}

package com.kaizencode.sensei.services;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.converters.CommandToTrainingPlan;
import com.kaizencode.sensei.converters.TrainingPlanToCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.repositories.TrainingPlanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingPlanDefaultService implements TrainingPlanService{

    private final TrainingPlanRepository trainingPlanRepository;
    private final CommandToTrainingPlan commandToPlan;
    private final TrainingPlanToCommand planToCommand;

    public TrainingPlanDefaultService(TrainingPlanRepository trainingPlanRepository, CommandToTrainingPlan commandToPlan, TrainingPlanToCommand planToCommand) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.commandToPlan = commandToPlan;
        this.planToCommand = planToCommand;
    }

    @Override
    public List<TrainingPlan> getTrainingPlans() {
        Iterable<TrainingPlan> trainingPlanIter = trainingPlanRepository.findAll();
        ArrayList<TrainingPlan> trainingPlans = new ArrayList<>();
        for (TrainingPlan trainingPlan : trainingPlanIter) {
            trainingPlans.add(trainingPlan);
        }
        return trainingPlans;
    }

    @Override
    public TrainingPlan getTrainingPlanById(Long id) {
        Optional<TrainingPlan> trainingPlan = trainingPlanRepository.findById(id);

        if(!trainingPlan.isPresent()){
            throw new RuntimeException("Couldn't find training plan of id " + id);
        }

        return trainingPlan.get();
    }

    @Override
    @Transactional
    public TrainingPlanCommand savePlanCommand(TrainingPlanCommand command) {
        TrainingPlan detachedPlan = commandToPlan.convert(command);
        TrainingPlan savedPlan = trainingPlanRepository.save(detachedPlan);
        return planToCommand.convert(savedPlan);
    }
}

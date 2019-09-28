package com.kaizencode.sensei.services;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.repositories.TrainingPlanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingPlanDefaultService implements TrainingPlanService{

    private TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanDefaultService(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
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
}

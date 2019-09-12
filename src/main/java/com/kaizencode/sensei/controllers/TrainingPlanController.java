package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.models.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TrainingPlanController {

    private TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @RequestMapping({"/"})
    public String showTrainingPlans(){

        StringBuilder stringBuilder = new StringBuilder();
        List<TrainingPlan> trainingPlans = trainingPlanService.getTrainingPlans();

        for (TrainingPlan trainingPlan : trainingPlans){
            stringBuilder.append("Training : " + trainingPlan.getDescription() + "\n");
        }

        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();

    }
}

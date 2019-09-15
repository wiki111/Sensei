package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TrainingPlanController {

    private TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @GetMapping({"/trainingplans/list"})
    public String showTrainingPlans(Model model){

        StringBuilder stringBuilder = new StringBuilder();
        //TODO : Make the service supply the list of training plans in form of String instead of doing it in a controller
        List<TrainingPlan> trainingPlans = trainingPlanService.getTrainingPlans();

        for (TrainingPlan trainingPlan : trainingPlans){
            stringBuilder.append("Training : " + trainingPlan.getDescription() + " \n");
        }

        model.addAttribute("trainingPlans", stringBuilder.toString());

        return "trainingplans/list";

    }
}

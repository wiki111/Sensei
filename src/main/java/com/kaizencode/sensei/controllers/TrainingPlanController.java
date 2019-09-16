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

        List<TrainingPlan> trainingPlans = trainingPlanService.getTrainingPlans();

        model.addAttribute("trainingPlans", trainingPlans);

        return "trainingplans/list";

    }
}

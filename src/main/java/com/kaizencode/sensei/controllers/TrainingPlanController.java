package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping({"/trainingplans/plan/{id}"})
    public String showTrainingPlanById(@PathVariable String id, Model model){

        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanById(Long.valueOf(id));

        model.addAttribute("trainingPlan", trainingPlan);

        return "/trainingplans/show";
    }


}

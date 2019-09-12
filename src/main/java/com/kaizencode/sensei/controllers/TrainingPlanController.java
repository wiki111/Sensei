package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.models.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TrainingPlanController {

    private TrainingPlanService trainingPlanService;

    public TrainingPlanController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @GetMapping({"/", "", "/test"})
    public String showTrainingPlans(Model model){

        StringBuilder stringBuilder = new StringBuilder();
        //TODO : Make the service supply the list of training plans in form of String instead of doing it in a controller
        List<TrainingPlan> trainingPlans = trainingPlanService.getTrainingPlans();

        for (TrainingPlan trainingPlan : trainingPlans){
            stringBuilder.append("Training : " + trainingPlan.getDescription() + "\n");
        }

        System.out.println(stringBuilder.toString());
        model.addAttribute("trainingPlans", stringBuilder.toString());

        return "testview";

    }
}

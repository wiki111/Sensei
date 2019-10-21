package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping({"/trainingplans/{id}/show"})
    public String showTrainingPlanById(@PathVariable String id, Model model){

        TrainingPlan trainingPlan = trainingPlanService.getTrainingPlanById(Long.valueOf(id));

        model.addAttribute("trainingPlan", trainingPlan);

        return "/trainingplans/show";
    }

    @RequestMapping("/trainingplans/new")
    public String newPlan(Model model){
        model.addAttribute("plan", new TrainingPlanCommand());
        return "trainingplans/form";
    }

    @RequestMapping("/trainingplans/{id}/update")
    public String updatePlan(@PathVariable String id, Model model){
        model.addAttribute("plan", trainingPlanService.getTrainingCommandById(Long.valueOf(id)));
        return "/trainingplans/form";
    }

    @PostMapping("/trainingplan/")
    public String saveOrUpdate(@ModelAttribute TrainingPlanCommand command){
        TrainingPlanCommand savedCommand = trainingPlanService.savePlanCommand(command);
        return "redirect:/trainingplans/" + savedCommand.getId() + "/show";
    }
}

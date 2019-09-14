package com.kaizencode.sensei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainingController {

    @GetMapping("/trainings/list")
    public String list(){
        return "trainings/list";
    }

}
